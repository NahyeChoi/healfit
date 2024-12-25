package healfit.service;

import healfit.dto.GymDto;
import healfit.entity.GymEntity;
import healfit.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;

    // 헬스장 지점 등록
    public GymEntity addGym(GymEntity gym) {
        return gymRepository.save(gym);
    }



    // 헬스장 지점 수정
    // 헬스장 지점 삭제
//    public void deleteGym(String gymNo) {
//        gymRepository.delete(gymRepository.findByGymNo(gymNo));
//    }
    // 헬스장 지점 조회
     public GymDto findByGymNo(String gymNo) {
         System.out.println(gymRepository.findById(1L));
         GymEntity gym = gymRepository.findByGymNo(gymNo);
         return GymDto.fromEntity(gym);
     }
}
