package healfit.repository;

import healfit.entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<MembershipEntity, Long> {
    MembershipEntity findByMembershipName(String name);
}
