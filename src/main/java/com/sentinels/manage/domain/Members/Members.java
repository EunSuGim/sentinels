package com.sentinels.manage.domain.Members;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @Column(nullable = false)
    private String etc;

    @Column(nullable = false)
    private LocalDate visitDate;

    @Builder
    public Members(String name, String tier, String etc, int age, LocalDate visitDate){

        if(!Objects.isNull(name)) this.name = name;
        if(!Objects.isNull(tier)) this.tier = tier;
        if(!Objects.isNull(etc)) this.etc = etc;
        if(!Objects.isNull(age)) this.age = age;
        if(!Objects.isNull(visitDate)) this.visitDate = visitDate;
    }

}
