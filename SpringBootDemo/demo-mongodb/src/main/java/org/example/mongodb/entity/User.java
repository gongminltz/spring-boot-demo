package org.example.mongodb.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * User
 *
 * @author gongmin
 * @date 2022/11/4 15:02
 */
@Data
@Document("user")
@Builder
public class User {
    @Id
    private Long id;
    private String name;
    private String phone;
    private String address;
    private LocalDateTime createTime;
}
