package com.graduation.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.entity.Members;
import com.graduation.app.form.MembersForm;
import com.graduation.app.record.MembersRecord;
import com.graduation.app.repository.MembersRepository;
import com.graduation.app.service.MembersService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    // 全件検索
    @Override
    public List<MembersDTO> getAllMembers(){
        MembersForm emptyForm = new MembersForm();
        return sortMembers(emptyForm);
    }

    // 条件付き検索
    @Override
    public List<MembersRecord> findAllMembers(MembersForm form) {
        return membersRepository.selectAll(form);
    }

    // formからDTOに変換（プロセスは後述）
    @Override
    public List<MembersDTO> sortMembers(MembersForm form){
        List<MembersRecord> MembersRecordList = findAllMembers(form);
        List<Members> MembersList = sendAllMembers(MembersRecordList);
        List<MembersDTO> MembersDTOList = sendAllMembersDTO(MembersList);

        return MembersDTOList;
    }

    // エンティティをDTOに変換
    @Override
    public List<MembersDTO> sendAllMembersDTO(List<Members> MembersList) {
        List<MembersDTO> membersDTOList = new ArrayList<>();
        for(Members Members : MembersList){
            MembersDTO membersDTO = new MembersDTO();
            membersDTO.setId(Members.getId());
            membersDTO.setMemberName(Members.getMemberName());
            membersDTO.setSex(Members.getSex());
            membersDTO.setEmployeeNumber(Members.getEmployeeNumber());
            membersDTO.setBumonName(Members.getBumonName());
            membersDTO.setVendingMachine(Members.getVendingMachine());

            membersDTOList.add(membersDTO);
        }

        return membersDTOList;
    }

    // レコードをエンティティに変換
    @Override
    public List<Members> sendAllMembers(List<MembersRecord> MembersRecordList) {
        List<Members> membersList = new ArrayList<>();
        for(MembersRecord MembersRecord : MembersRecordList){
            Members members = new Members();
            members.setId(MembersRecord.getId());
            members.setMemberName(MembersRecord.getMemberName());
            members.setSex(MembersRecord.getSex());
            members.setEmployeeNumber(MembersRecord.getEmployeeNumber());
            members.setBumonName(MembersRecord.getBumonName());
            members.setVendingMachine(MembersRecord.getVendingMachine());

            membersList.add(members);
        }

        return membersList;
    }

    // ボタンで自販機使用回数を増加
    public int incrementVendingMachine(Long id) {
        membersRepository.incrementVendingMachine(id);
        return membersRepository.findVendingMachineCountById(id);
    }

    // ボタンで自販機使用回数を減少
    public int decrementVendingMachine(Long id) {
        membersRepository.decrementVendingMachine(id);
        return membersRepository.findVendingMachineCountById(id);
    }
    
}