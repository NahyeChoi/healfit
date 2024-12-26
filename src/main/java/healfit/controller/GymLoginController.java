package healfit.controller;

import healfit.dto.GymDto;
import healfit.dto.GymLoginDto;
import healfit.service.GymService;
import healfit.utils.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/login")
public class GymLoginController {

    @Autowired
    GymService gymService;

    // 헬스장 로그인
    @PostMapping("")
    public ResponseEntity<String> login(@RequestBody GymLoginDto loginGym, HttpServletRequest request) {
        //1. 회원이 입력한 사업자 번호로 DB에서 조회를 함
        GymDto findGym = gymService.findByGymNo(loginGym.getGymNo());

        //2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        if (!findGym.getGymPassword().equals(loginGym.getGymPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
        }

        // HttpSession 사용
        // 세션이 있으면 해당 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        // 세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_GYM, findGym);

        return ResponseEntity.ok().body("Login successfully");
    }

    // 로그아웃시 해당 세션 정보 제거
    public String logout(HttpServletRequest request) {
        // 새로 생성하지 않는 조건(false)로 세션 조회
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 정보 삭제
        }
        return "Logout successful";
    }

    // 헬스장 비밀번호 찾기
}
