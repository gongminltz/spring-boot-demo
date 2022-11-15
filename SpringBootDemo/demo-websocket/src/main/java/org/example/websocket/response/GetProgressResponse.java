package org.example.websocket.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * GetProgressResponse
 *
 * @author gongmin
 * @date 2022/11/15 10:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProgressResponse implements Serializable {
    private String userId;
    private int progress;
}
