package com.example.boardproject.validate;

import com.example.boardproject.dto.MemberDTO;
import com.example.boardproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckLoginValidator extends AbstractValidator<MemberDTO>{
    private final MemberRepository memberRepository;

    @Override
    public void doValidate(MemberDTO dto, Errors errors){
        if(memberRepository.existsByLoginId(dto.getLoginId())){
            errors.rejectValue("loginId", "아이디 중복 오류", "이미 사용중인 아이디");
        }
    }
}
