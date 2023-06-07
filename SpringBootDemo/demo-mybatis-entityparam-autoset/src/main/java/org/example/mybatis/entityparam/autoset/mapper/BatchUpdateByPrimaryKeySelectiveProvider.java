package org.example.mybatis.entityparam.autoset.mapper;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Iterator;
import java.util.Set;

/**
 * 批量更新
 *
 * @author gongmin
 * @date 2023/6/6 14:15
 */
public class BatchUpdateByPrimaryKeySelectiveProvider extends MapperTemplate {
    public BatchUpdateByPrimaryKeySelectiveProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 拼update sql, 使用case when方式，id为主键
     *
     * @param ms
     * @return
     */

    public String batchUpdateByPrimaryKeySelective(MappedStatement ms) {
        Class<?> entityClass = this.getEntityClass(ms);

        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, this.tableName(entityClass)));
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        Iterator columnIterator = columnList.iterator();

        sql.append(" SET ");

        while (columnIterator.hasNext()) {
            EntityColumn column = (EntityColumn) columnIterator.next();

            sql.append(column.getColumn()).append(" = (case id ");

            sql.append("<foreach collection=\"list\" item=\"record\" >");

            sql.append(" <choose> ");
            sql.append(" <when test = \"record." + column.getEntityField().getName()  + " != null\">");
            sql.append(" when #{record.id} then " + column.getColumnHolder("record"));
            sql.append(" </when> ");
            sql.append(" <otherwise> ");
            sql.append(" when #{record.id} then " + column.getColumn());
            sql.append(" </otherwise> ");
            sql.append(" </choose> ");

            sql.append("</foreach>");
            sql.append(" end)");

            if (columnIterator.hasNext()) {
                sql.append(",");
            }
        }

        sql.append(" where id in (");
        sql.append("<foreach collection=\"list\" item=\"record\"  separator=\",\" >");
        sql.append(" #{record.id}");
        sql.append("</foreach>");
        sql.append(")");

        return sql.toString();
    }
}