package com.sentinels.manage.service;


import com.sentinels.manage.domain.Members.Members;
import com.sentinels.manage.domain.Members.MembersRepository;
import com.sentinels.manage.web.dto.MembersRequestDto;
import com.sentinels.manage.web.dto.MembersRequestUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MembersService {

    private final MembersRepository membersRepository;

    public Long save (MembersRequestDto requestDto){
        return membersRepository.save(requestDto.toEntity()).getId();
    }

    public Members findById(Long id){
        Members members =
                membersRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 맴버 정보가 없습니다."));
        return members;
    }

    public List<Members> findByAll(){
        return membersRepository.findAll();
    }

    public void deleteById(Long id){
        Members members =
                membersRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 맴버 정보가 없습니다."));
        membersRepository.delete(members);

    }

    @Transactional
    public Long update(Long id, MembersRequestUpdateDto requestUpdateDto){
        Members members =
                membersRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("해당 맴버 정보가 없습니다."));
        members.update(requestUpdateDto);
        return id;
    }

}
