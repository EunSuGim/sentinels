package com.sentinels.manage.controller.Members;

import com.sentinels.manage.Application;
import com.sentinels.manage.domain.Members.Members;
import com.sentinels.manage.domain.Members.MembersRepository;
import com.sentinels.manage.web.dto.MembersRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class MembersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MembersRepository membersRepository;

    @After
    public void clearDown() throws Exception{
        membersRepository.deleteAll();
    }

    @Test
    public void Members_Enrolled_api_Test(){
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

        MembersRequestDto requestDto =
                MembersRequestDto.builder()
                        .name(name)
                        .tier(tier)
                        .age(age)
                        .etc(etc)
                        .visitDate(visitdate)
                        .build();

        String url = "http://localhost:" + port + "/api/v1/members";

        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url,requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Members> membersList = membersRepository.findAll();

        assertThat(membersList.get(0).getName()).isEqualTo(name);
    }
}
