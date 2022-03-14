package com.sentinels.manage.service;


import com.sentinels.manage.domain.Members.MembersRepository;
import com.sentinels.manage.web.dto.MembersRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MembersService {

    private final MembersRepository membersRepository;

    public Long save (MembersRequestDto requestDto){
        return membersRepository.save(requestDto.toEntity()).getId();
    }
}
