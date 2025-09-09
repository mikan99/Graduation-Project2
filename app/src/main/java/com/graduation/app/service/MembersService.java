package com.graduation.app.service;

import java.util.List;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.entity.Members;
import com.graduation.app.record.MembersRecord;

// DTO、entity、Recordを用いて記述
public interface MembersService {
    
    public List<MembersDTO> sortMembers();
    public List<MembersRecord> findAllMembers();
    public List<MembersDTO> sendAllMembersDTO(List<Members> MembersList);
    public List<Members> sendAllMembers(List<MembersRecord> MembersRecordList);

    Integer incrementVendingMachine(Integer id);
}
