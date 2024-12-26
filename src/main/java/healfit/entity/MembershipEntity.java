package healfit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "membership")
public class MembershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String membershipName;

    @Column
    private Integer price;

    @Column
    private Integer period;

    @Column
    private Integer numberOfUse;

    public MembershipEntity(String membershipName, Integer price, Integer period, Integer numberOfUse) {
        this.membershipName = membershipName;
        this.price = price;
        this.period = period;
        this.numberOfUse = numberOfUse;
    }
}
