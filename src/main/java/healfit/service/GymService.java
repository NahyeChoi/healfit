package healfit.service;

import healfit.dto.GymDto;
import healfit.entity.GymEntity;
import healfit.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional
    public GymDto updateGym(String gymNo, GymDto updateGym) {
        GymEntity gym = gymRepository.findByGymNo(gymNo);

        if (gym.getGymNo().equals(updateGym.getGymNo())
                && gym.getId().equals(updateGym.getId())) {
            if(!gym.getGymPassword().equals(updateGym.getGymPassword())) {
                gym.setGymPassword(updateGym.getGymPassword());
            }
            if (!gym.getGymAddress().equals(updateGym.getGymAddress())) {
                gym.setGymAddress(updateGym.getGymAddress());
            }
            if (!gym.getGymPhone().equals(updateGym.getGymPhone())) {
                gym.setGymPhone(updateGym.getGymPhone());
            }
        } else {
            return GymDto.fromEntity(gym);
        }
        return GymDto.fromEntity(gym);
    }
    // 헬스장 지점 삭제
//    public void deleteGym(String gymNo) {
//        gymRepository.delete(gymRepository.findByGymNo(gymNo));
//    }
    // 헬스장 지점 조회

     public GymDto findByGymNo(String gymNo) {
         GymEntity gym = gymRepository.findByGymNo(gymNo);
         return GymDto.fromEntity(gym);
     }
}
