package com.graduation.app.service;

import java.util.List;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.entity.Members;
import com.graduation.app.form.MembersForm;
import com.graduation.app.record.MembersRecord;

// DTO、entity、Recordを用いて記述
public interface MembersService {
    
    public List<MembersDTO> getAllMembers();
    public List<MembersDTO> sortMembers(MembersForm form);
    public List<MembersRecord> findAllMembers(MembersForm form);
    public List<MembersDTO> sendAllMembersDTO(List<Members> MembersList);
    public List<Members> sendAllMembers(List<MembersRecord> MembersRecordList);

    public int incrementVendingMachine(Long id);
    public int decrementVendingMachine(Long id);
}
