package com.sentinels.manage.domain.Members;

import com.sentinels.manage.web.dto.MembersRequestUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String tier;

    @Column(nullable = false)
    private int age;

    @Column(nullable = true)
    private String etc;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private LocalDate startDate;

    @Builder
    public Members(String name, String tier, String etc, int age, String gender, LocalDate startDate){

        if(!Objects.isNull(name)) this.name = name;
        if(!Objects.isNull(tier)) this.tier = tier;
        if(!Objects.isNull(etc)) this.etc = etc;
        if(!Objects.isNull(age)) this.age = age;
        if(!Objects.isNull(gender)) this.gender = gender;
        if(!Objects.isNull(startDate)) this.startDate = startDate;
    }

    public void update(MembersRequestUpdateDto requestUpdateDto){
        this.name = requestUpdateDto.getName();
        this.tier = requestUpdateDto.getTier();
        this.age = requestUpdateDto.getAge();
        this.etc = requestUpdateDto.getEtc();
        this.gender = requestUpdateDto.getGender();
        this.startDate = requestUpdateDto.getStartDate();
    }

}
