package healfit.service;

import healfit.dto.MembershipDto;
import healfit.entity.MembershipEntity;
import healfit.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembershipService {

    @Autowired
    MembershipRepository membershipRepository;

    public void add(MembershipDto newMembership) {
        membershipRepository.save(newMembership.toMembershipEntity());
    }

    //수정
    @Transactional
    public void update(String name, MembershipDto updateMembership) {
        MembershipEntity updated = membershipRepository.findByMembershipName(name);

        if(!updated.getMembershipName().equals(updateMembership.getMembershipName())) {
            updated.setMembershipName(updateMembership.getMembershipName());
        }
        if (!updated.getPrice().equals(updateMembership.getPrice())) {
            updated.setPrice(updateMembership.getPrice());
        }
        if (!updated.getPeriod().equals(updateMembership.getPeriod())) {
           updated.setPeriod(updateMembership.getPeriod());
        }
        if (!updated.getNumberOfUse().equals(updateMembership.getNumberOfUse())) {
            updated.setNumberOfUse(updateMembership.getNumberOfUse());
        }
    }

    public void delete(Long id) {

    }

    public List<MembershipDto> getAll() {
        List<MembershipEntity> membershipEntityList = membershipRepository.findAll();
        List<MembershipDto> membershipDtoList = new ArrayList<>();
        for (MembershipEntity membershipEntity : membershipEntityList) {
            membershipDtoList.add(MembershipDto.fromEntity(membershipEntity));
        }
        return membershipDtoList;
    }
}
