package com.example.boardproject.service;

import com.example.boardproject.dto.LoginDTO;
import com.example.boardproject.dto.MemberDTO;
import com.example.boardproject.entity.Member;
import com.example.boardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member register(Member member) {
        return memberRepository.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateDuplicateLoginId(MemberDTO memberDTO) {
        return memberRepository.existsByLoginId(memberDTO.getLoginId());
    }
    @Override
    @Transactional(readOnly = true)
    public boolean validateDuplicateLoginId(LoginDTO loginDTO) {
        return memberRepository.existsByLoginId(loginDTO.getLoginId());
    }

}



