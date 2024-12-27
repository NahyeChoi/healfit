package healfit.dto;

import healfit.entity.LockerEntity;
import healfit.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {

    private Long memberId;
    private String name;
    private String phoneNumber;
    private Boolean gender;
    private Date birthDate;
    private String address;
    private LockerEntity locker;

    // Entity로 변환 메서드
    public MemberEntity toEntity() {
        return new MemberEntity(
                this.memberId,
                this.name,
                this.phoneNumber,
                this.gender,
                this.birthDate,
                this.address,
                this.locker
        );
    }

    // 저장된 데이터를 DTO로 변환 후 반환
    public static MemberDto fromEntity(MemberEntity entity) {
        return new MemberDto(
                entity.getMemberId(),
                entity.getName(),
                entity.getPhoneNumber(),
                entity.getGender(),
                entity.getBirthDate(),
                entity.getAddress(),
                entity.getLocker()
        );
    }


}
