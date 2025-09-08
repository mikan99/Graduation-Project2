package com.graduation.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.entity.Members;
import com.graduation.app.record.MembersRecord;
import com.graduation.app.repository.MembersRepository;
import com.graduation.app.service.MembersService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    @Override
    public List<MembersDTO> sortMembers(){
        List<MembersRecord> MembersRecordList = findAllMembers();
        List<Members> MembersList = sendAllMembers(MembersRecordList);
        List<MembersDTO> MembersDTOList = sendAllMembersDTO(MembersList);

        return MembersDTOList;
    }

    @Override
    public List<MembersRecord> findAllMembers() {
        return membersRepository.selectAll();
    }

    @Override
    public List<MembersDTO> sendAllMembersDTO(List<Members> MembersList) {
        List<MembersDTO> MembersDTOList = new ArrayList<>();
        for(Members Members : MembersList){
            MembersDTO MembersDTO = new MembersDTO();
            MembersDTO.setId(Members.getId());
            MembersDTO.setMemberName(Members.getMemberName());
            MembersDTO.setSex(Members.getSex());
            MembersDTO.setEmployeeNumber(Members.getEmployeeNumber());
            MembersDTO.setBumonName(Members.getBumonName());

            MembersDTOList.add(MembersDTO);
        }

        return MembersDTOList;
    }

    @Override
    public List<Members> sendAllMembers(List<MembersRecord> MembersRecordList) {
        List<Members> MembersList = new ArrayList<>();
        for(MembersRecord MembersRecord : MembersRecordList){
            Members Members = new Members();
            Members.setId(MembersRecord.getId());
            Members.setMemberName(MembersRecord.getMemberName());
            Members.setSex(MembersRecord.getSex());
            Members.setEmployeeNumber(MembersRecord.getEmployeeNumber());
            Members.setBumonName(MembersRecord.getBumonName());

            MembersList.add(Members);
        }

        return MembersList;
    }
}