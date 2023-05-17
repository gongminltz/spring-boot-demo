package org.example.custom.valid.request;

import lombok.Getter;
import lombok.Setter;
import org.example.custom.valid.annotation.UniqueTitle;

import javax.validation.constraints.NotEmpty;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/5/17 8:39
 */
@Getter
@Setter
public class AddUserRequest {
    @UniqueTitle
    private String userName;

    @NotEmpty(message = "不能为空")
    private String phone;
}
