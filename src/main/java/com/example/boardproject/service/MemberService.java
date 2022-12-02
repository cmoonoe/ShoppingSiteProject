package com.example.boardproject.service;

import com.example.boardproject.dto.LoginDTO;
import com.example.boardproject.dto.MemberDTO;
import com.example.boardproject.entity.Member;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {

    Member register(Member member);

    @Transactional(readOnly = true)
    boolean validateDuplicateLoginId(MemberDTO memberDTO);

    @Transactional(readOnly = true)
    boolean validateDuplicateLoginId(LoginDTO loginDTO);


}
