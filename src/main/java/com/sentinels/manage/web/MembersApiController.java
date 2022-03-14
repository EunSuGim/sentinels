package com.sentinels.manage.web;

import com.sentinels.manage.service.MembersService;
import com.sentinels.manage.web.dto.MembersRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MembersApiController {

    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public Long save(@RequestBody MembersRequestDto requestDto){
        return membersService.save(requestDto);
    }
}
