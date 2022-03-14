package com.sentinels.manage.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MembersRequestUpdateDto {
    private String name;
    private String tier;
    private int age;
    private String etc;
    private LocalDate visitDate;

    @Builder
    public MembersRequestUpdateDto(String name, String tier, int age, String etc, LocalDate visitDate){
        this.name = name;
        this.tier = tier;
        this.age = age;
        this.etc = etc;
        this.visitDate = visitDate;
    }
}
