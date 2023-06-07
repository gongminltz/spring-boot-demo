package org.example.mybatis.entityparam.autoset.mapper;

import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * 批量插入
 *
 * @author gongmin
 * @date 2023/6/6 14:14
 */
@RegisterMapper
public interface BatchInsertMapper<T> {
    @InsertProvider(
            type = BatchInsertProvider.class,
            method = "dynamicSQL"
    )
    int batchInsert(List<T> recordList);
}
