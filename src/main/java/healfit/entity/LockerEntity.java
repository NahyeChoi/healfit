package healfit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locker")
public class LockerEntity {

    @Id
    @Column(name = "locker_id")
    private Long lockerId;

    @OneToOne(mappedBy = "locker")
    private MemberEntity member;

}
