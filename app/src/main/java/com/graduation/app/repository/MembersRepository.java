package com.graduation.app.repository;

import java.util.List;

import com.graduation.app.record.MembersRecord;

public interface MembersRepository {
    
    List<MembersRecord> selectAll();

}
