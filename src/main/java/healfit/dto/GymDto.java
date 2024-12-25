package healfit.dto;

import healfit.entity.GymEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GymDto {

    private Long id;
    private String gymName;
    private String gymAddress;
    private String gymNo; //사업자번호
    private String gymPhone;
    private String gymPassword;

    public static GymDto fromEntity(GymEntity entity) {
        return new GymDto(
                entity.getId(),
                entity.getGymName(),
                entity.getGymAddress(),
                entity.getGymNo(),
                entity.getGymPhone(),
                entity.getGymPassword()
        );
    }
}
