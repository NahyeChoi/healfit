package healfit.controller;

import healfit.entity.GymEntity;
import healfit.service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class GymController {

    @Autowired
    GymService gymService;

    // 헬스장 지점 등록
    @PostMapping("")
    public ResponseEntity addGym(@RequestBody GymEntity gym) {
        return ResponseEntity.ok(gymService.addGym(gym));
    }

    // 헬스장 지점 수정

    // 헬스장 지점 삭제

    // 헬스장 지점 조회
}
