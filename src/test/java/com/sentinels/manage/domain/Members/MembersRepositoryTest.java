package com.sentinels.manage.domain.Members;

import com.sentinels.manage.Application;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MembersRepositoryTest {

    @Autowired
    MembersRepository membersRepository;

    @After
    public void cleanUp(){
        membersRepository.deleteAll();
    }

    @Test
    public void loadMembers(){
        String name;
        String tier;
        String etc;
        int age;
        LocalDate visitdate;

        name = "정자셉니다";
        tier = "P";
        etc = " ";
        age = 29;
        visitdate = LocalDate.now();

        membersRepository.save(Members.builder()
                        .name(name)
                        .tier(tier)
                        .etc(etc)
                        .age(age)
                        .visitDate(visitdate)
                        .build());

        List<Members> membersList = membersRepository.findAll();

        Members members = membersList.get(0);

        assertThat(members.getName()).isEqualTo(name);
        assertThat(members.getVisitDate()).isEqualTo(visitdate);

    }
}
