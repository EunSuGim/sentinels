package com.sentinels.manage.controller.Members;

import com.sentinels.manage.Application;
import com.sentinels.manage.domain.Members.Members;
import com.sentinels.manage.domain.Members.MembersRepository;
import com.sentinels.manage.web.dto.MembersRequestDto;
import com.sentinels.manage.web.dto.MembersRequestUpdateDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
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

    @Test
    public void deleteMembers(){
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

        Long removeId = membersRepository.save(Members.builder()
                .name(name)
                .tier(tier)
                .etc(etc)
                .age(age)
                .visitDate(visitdate)
                .build()).getId();

        String url = "http://localhost:" + port + "/api/v1/members/" + removeId;

        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(url, HttpMethod.DELETE, new HttpEntity<>(removeId), Long.class);

        List<Members> allMembers = membersRepository.findAll();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(allMembers.size()).isEqualTo(0);

    }

    @Test
    public void updateMembers(){
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

        Members saveMembers =
                membersRepository.save(Members.builder()
                                .name(name)
                                .tier(tier)
                                .etc(etc)
                                .age(age)
                                .visitDate(visitdate)
                        .build());

        Long updateId = saveMembers.getId();

        String expectedName = "고등어";

        MembersRequestUpdateDto updateDto =
                MembersRequestUpdateDto.builder()
                        .name(expectedName)
                        .tier(tier)
                        .age(age)
                        .etc(etc)
                        .visitDate(visitdate)
                        .build();

        String url = "http://localhost:" + port + "/api/v1/members/" + updateId;

        ResponseEntity<Long> responseEntity = testRestTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(updateDto), Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Members> all = membersRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);

    }

    @Test
    public void allLoadMembers(){
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


        String url = "http://localhost:" + port + "/api/v1/members";

        ResponseEntity<Members[]> responseEntity = testRestTemplate.getForEntity(url, Members[].class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Members members = Arrays.asList(responseEntity.getBody()).get(0);

        assertThat(members.getName()).isEqualTo(name);
        assertThat(members.getTier()).isEqualTo(tier);


    }

    @Test
    public void loadIdMembers(){
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

        Members members = membersRepository.save(Members.builder()
                .name(name)
                .tier(tier)
                .etc(etc)
                .age(age)
                .visitDate(visitdate)
                .build());

        Long givenDataId = members.getId();

        String url = "http://localhost:" + port + "/api/v1/members/" + givenDataId;

        ResponseEntity<Members> responseEntity = testRestTemplate.getForEntity(url, Members.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getTier()).isEqualTo(tier);

    }

}
