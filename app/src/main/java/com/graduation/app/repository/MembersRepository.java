package com.graduation.app.repository;

import java.util.List;

import com.graduation.app.form.MembersForm;
import com.graduation.app.record.MembersRecord;

public interface MembersRepository {
    
    List<MembersRecord> selectAll(MembersForm form);

    void incrementVendingMachine(Long id);
    void decrementVendingMachine(Long id);

    int findVendingMachineCountById(Long id);
}
