package com.geektime.pojo;

import lombok.Data;

/**
 * @author YangMin
 * @date 2020/12/6 21:55
 */
@Data
public class User {

    private Long id;

    private String username;

    @Override
    public String toString() {
        return "id: " + id + "; username: " + username;
    }
}
