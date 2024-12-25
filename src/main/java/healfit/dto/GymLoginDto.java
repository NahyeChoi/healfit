package healfit.dto;

import healfit.entity.GymEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GymLoginDto {

    private String gymNo; //사업자번호
    private String gymPassword;

    public GymEntity toGymEntity() {
        return new GymEntity(
          this.gymNo,
          this.gymPassword
        );
    }
}
