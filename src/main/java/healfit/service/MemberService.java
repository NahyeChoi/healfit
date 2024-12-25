package healfit.service;

import healfit.dto.MemberDto;
import healfit.entity.MemberEntity;
import healfit.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberDto signUp(MemberDto member) {
        MemberEntity entity = member.toEntity();
        MemberEntity savedEntity = memberRepository.save(entity);

        return MemberDto.fromEntity(savedEntity);
    }
}
