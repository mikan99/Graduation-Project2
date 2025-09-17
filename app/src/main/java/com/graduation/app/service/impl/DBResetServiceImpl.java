package com.graduation.app.service.impl;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.graduation.app.service.DBResetService;

import jakarta.transaction.Transactional;

@Service
public class DBResetServiceImpl implements DBResetService{

    private final DataSource data;

    public DBResetServiceImpl(DataSource data) {
        this.data = data;
    }

    @Transactional
    @Scheduled(cron = "* 1 * * * *") // 秒　分　時　日　月　曜日
    public void resetDatabase() throws Exception {
        try (Connection conn = data.getConnection()) {
            conn.createStatement().execute("DELETE FROM members"); // データ削除
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("data/01_members.sql")); // データ挿入
        }
    }
}