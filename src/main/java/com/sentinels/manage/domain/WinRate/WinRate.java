package com.sentinels.manage.domain.WinRate;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class WinRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private int match;

    @Column(nullable = true)
    private int win;

    @Column(nullable = true)
    private int lose;

}
