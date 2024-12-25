package healfit.controller;

import healfit.dto.GymDto;
import healfit.dto.GymLoginDto;
import healfit.entity.GymEntity;
import healfit.service.GymLoginService;
import healfit.service.GymService;
import healfit.utils.SessionManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    @Autowired
    GymLoginService gymLoginService;
    @Autowired
    private SessionManager sessionManager;

    // 헬스장 로그인
    @PostMapping("")
    public ResponseEntity<String> login(@RequestBody GymLoginDto loginGym, HttpServletResponse response) {
        //1. 회원이 입력한 사업자 번호로 DB에서 조회를 함
        GymDto findGym = gymService.findByGymNo(loginGym.getGymNo());

        //2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        if(!findGym.getGymPassword().equals(loginGym.getGymPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
        }

        // 로그인 성공 시 세션에 loginGym 저장, 쿠키도 HttpServletResponse 에 저장
        sessionManager.createSession(loginGym, response);

        return ResponseEntity.ok().body("Login successfully");
    }

    // 로그아웃시 해당 세션 정보 제거
    public String logout(HttpServletRequest request) {
        sessionManager.expire(request);
        return "Logout successful";
    }

    // 헬스장 비밀번호 찾기
}
