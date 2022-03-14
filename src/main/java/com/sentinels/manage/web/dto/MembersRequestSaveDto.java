package com.sentinels.manage.web.dto;


import com.sentinels.manage.domain.Members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MembersRequestSaveDto {
    private String name;
    private String tier;
    private int age;
    private String etc;
    private LocalDate visitDate;

    @Builder
    public MembersRequestSaveDto(String name, String tier, int age, String etc, LocalDate visitDate){
        this.name = name;
        this.tier = tier;
        this.age = age;
        this.etc = etc;
        this.visitDate = visitDate;
    }

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .tier(tier)
                .age(age)
                .etc(etc)
                .visitDate(visitDate)
                .build();
    }
}
