package org.example.mybatis.entityparam.autoset.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/5/17 10:45
 */
@Getter
@Setter
public class BaseEntity {
    @Id
    private String id;
    private Date createDate;
    private Date modifyDate;
}
