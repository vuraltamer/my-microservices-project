package com.project.dto;

import com.project.dto.base.BaseDto;

public class OrderDto extends BaseDto {

    private String name;

    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
