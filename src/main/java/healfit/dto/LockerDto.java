package healfit.dto;

import healfit.entity.LockerEntity;
import healfit.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LockerDto {

    private Long lockerId;

    public static LockerDto fromEntity(LockerEntity entity){
        return new LockerDto(
          entity.getLockerId()
        );
    }
}
