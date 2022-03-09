package com.sentinels.manage.domain.Members;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String tier;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String etc;

    @Column(nullable = false)
    private LocalDate visitDate;

}
