package healfit.repository;

import healfit.entity.GymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface GymRepository extends JpaRepository<GymEntity, Long> {
    GymEntity findByGymNo(String gymNo);
}
