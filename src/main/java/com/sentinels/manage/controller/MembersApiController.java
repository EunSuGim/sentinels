package com.sentinels.manage.controller;

import com.sentinels.manage.domain.Members.Members;
import com.sentinels.manage.service.MembersService;
import com.sentinels.manage.web.dto.MembersRequestDto;
import com.sentinels.manage.web.dto.MembersRequestUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MembersApiController {

    private final MembersService membersService;

    @PostMapping(value = "/api/v1/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long saveJson(@RequestBody MembersRequestDto requestDto){

        System.out.println("aaaaaaaaaaaaaa"+requestDto.getName());

        return membersService.save(requestDto);
    }

    @PostMapping(value = "/api/v1/members", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Long saveForm(MembersRequestDto requestDto){

        System.out.println("aaaaaaaaaaaaaa"+requestDto.getName());

        return membersService.save(requestDto);
    }

    @GetMapping("/api/v1/members/{id}")
    public Members findById(@PathVariable Long id){
        return membersService.findById(id);
    }
    @GetMapping("/api/v1/members")
    public List<Members> findByAll(){
        return membersService.findByAll();
    }

    @DeleteMapping("/api/v1/members/{id}")
    public void deleteById(@PathVariable Long id){
        membersService.deleteById(id);
    }

    @PutMapping("/api/v1/members/{id}")
    public Long update(@PathVariable Long id, @RequestBody MembersRequestUpdateDto requestUpdateDto){
        return membersService.update(id, requestUpdateDto);
    }
}

