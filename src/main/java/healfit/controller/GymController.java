package healfit.controller;

import healfit.dto.GymDto;
import healfit.entity.GymEntity;
import healfit.service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/home")
public class GymController {

    @Autowired
    GymService gymService;

    // 헬스장 지점 등록
    @PostMapping("")
    public ResponseEntity<GymEntity> addGym(@RequestBody GymEntity newGym) {
        return ResponseEntity.ok(gymService.addGym(newGym));
    }

    // 헬스장 지점 수정
    // 전화번호, 주소, 패스워드
    @PatchMapping("/{gymNo}")
    public ResponseEntity<GymDto> updateGym(@PathVariable("gymNo") String gymNo, @RequestBody GymDto updateGym) {
        return ResponseEntity.ok(gymService.updateGym(gymNo, updateGym));
    }


    // 헬스장 지점 삭제
    @DeleteMapping("/{gymNo}")
    public ResponseEntity<String> deleteGym(@PathVariable String gymNo) {
//        gymService.deleteGym(gymNo);
        return ResponseEntity.ok().body("Gym deleted successfully");
    }
    // 헬스장 지점 조회

}
