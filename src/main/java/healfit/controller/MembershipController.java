package healfit.controller;

import healfit.dto.GymDto;
import healfit.dto.MembershipDto;
import healfit.entity.MembershipEntity;
import healfit.service.MembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    MembershipService membershipService;

    //등록
    @PostMapping("")
    public String addMembership(@RequestBody MembershipDto membershipDto) {
        try {
            membershipService.add(membershipDto);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "멤버쉽 등록 완료";
    }

    //수정
    @PatchMapping("/{name}")
    public String updateMembership(@PathVariable("name") String name, @RequestBody MembershipDto membershipDto) {
        membershipService.update(name, membershipDto);
        return "멤버쉽 수정 완료";
    }
    //삭제
    @DeleteMapping("/{id}")
    public String deleteMembership(@PathVariable("id") Long id) {
        membershipService.delete(id);
        return "멤버쉽 삭제 완료";
    }

    //조회
    @GetMapping("")
    public List<MembershipDto> getMemberships() {
        List<MembershipDto> membershipList = membershipService.getAll();
        return membershipList;
    }
}
