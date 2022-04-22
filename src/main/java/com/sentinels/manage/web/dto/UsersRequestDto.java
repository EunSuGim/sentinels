package com.sentinels.manage.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersRequestDto {
    private String userId;
    private String password;
    private String name;


    @Builder
    public UsersRequestDto(String userId, String password, String name){
        this.userId = userId;
        this.password = password;
        this.name = name;

    }
}
