package org.example.mybatis.entityparam.autoset.mapper;

import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * 批量插入
 *
 * @author gongmin
 * @date 2023/6/6 14:14
 */
@RegisterMapper
public interface BatchUpdateMapper<T> {
    @UpdateProvider(
            type = BatchUpdateByPrimaryKeySelectiveProvider.class,
            method = "dynamicSQL"
    )
    int batchUpdateByPrimaryKeySelective(List<T> recordList);
}
