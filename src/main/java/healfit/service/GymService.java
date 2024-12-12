package healfit.service;

import healfit.entity.GymEntity;
import healfit.repository.GymRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GymService {

    @Autowired
    GymRepository gymRepository;

    // 헬스장 지점 등록
    public GymEntity addGym(GymEntity gym) {
        return gymRepository.save(gym);
    }

    // 헬스장 지점 수정
    // 헬스장 지점 삭제
    // 헬스장 지점 조회
}
