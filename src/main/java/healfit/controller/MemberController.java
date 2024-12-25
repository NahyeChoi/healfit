package healfit.controller;

import healfit.dto.MemberDto;
import healfit.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    // 회원등록
    @PostMapping("")
    public ResponseEntity signUpMember(@RequestBody MemberDto member) {
        log.info("Sign up member: {}", member);
        memberService.signUp(member);
        return ResponseEntity.ok().body("Member Create successfully");
    }

    // 회원조회

    // 회원수정

    // 회원삭제
}
