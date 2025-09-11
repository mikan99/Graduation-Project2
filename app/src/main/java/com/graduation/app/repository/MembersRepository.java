package com.graduation.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.graduation.app.form.MembersForm;
import com.graduation.app.record.MembersRecord;

public interface MembersRepository {
    
    List<MembersRecord> selectAll(MembersForm form);

    // vendingMachineを+1する
    void incrementVendingMachine(String id);

    // idで再取得
    MembersRecord findById(@Param("id") String id);
}
