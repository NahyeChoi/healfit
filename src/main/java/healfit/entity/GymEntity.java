package healfit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gym")
public class GymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String gymName;

    @Column
    private String gymAddress;

    @Column
    private String gymNo;

    @Column
    private String gymPhone;

    @Column
    private String gymPassword;

    public GymEntity(String gymNo, String gymPassword) {
        this.gymNo = gymNo;
        this.gymPassword = gymPassword;
    }
}
