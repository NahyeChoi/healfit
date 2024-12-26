package healfit.dto;

import healfit.entity.MembershipEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembershipDto {

    private String membershipName;
    private Integer price;
    private Integer period;
    private Integer numberOfUse;


    public static MembershipDto fromEntity(MembershipEntity entity) {
        return new MembershipDto(
                entity.getMembershipName(),
                entity.getPrice(),
                entity.getPeriod(),
                entity.getNumberOfUse()
        );
    }

    public MembershipEntity toMembershipEntity() {
        return new MembershipEntity(
                this.membershipName,
                this.price,
                this.period,
                this.numberOfUse
        );
    }
}
