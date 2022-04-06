package com.sentinels.manage.web.dto;


import com.sentinels.manage.domain.Members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class MembersRequestDto {
    private String name;
    private String tier;
    private int age;
    private String etc;
    private String gender;
    private LocalDate startDate;

    @Builder
    public MembersRequestDto(String name,String tier,int age,String etc,String gender, LocalDate startDate){
        this.name = name;
        this.tier = tier;
        this.age = age;
        this.etc = etc;
        this.gender = gender;
        this.startDate = startDate;
    }

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .tier(tier)
                .age(age)
                .etc(etc)
                .gender(gender)
                .startDate(startDate)
                .build();
    }

}
