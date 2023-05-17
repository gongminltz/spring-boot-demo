package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * TestMapper
 *
 * @author gongmin
 * @date 2023/4/28 9:54
 */
@Mapper
public interface TestMapper {
    /**
     * 数据库查询随机数
     */
    @Select("select uuid()")
    String getUUid();
}
