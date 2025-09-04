package com.graduation.app.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.graduation.app.service.MembersService;

@Service
public class MembersServiceImpl implements MembersService {

    private final SqlSessionTemplate sqlSessionTemplate;

    public MembersServiceImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Members> findAllType() {
        return sqlSessionTemplate.getMapper(com.graduation.app.repository.MembersMapper.class).selectAll();
    }
}

//以下重大事案の際のコード
// private final BusinessesMapper businessesMapper;

//     @Override
//     public List<BusinessesDTO> sortBusinesses(){
//         System.out.print("Hello World!! ☆--^w^/ ");

//         List<BusinessesRecord> BusinessesRecordList = findAllBusinesses();
//         List<Businesses> BusinessesList = sendAllBusinesses(BusinessesRecordList);
//         List<BusinessesDTO> BusinessesDTOList = sendAllDtoBusinesses(BusinessesList);
//         return BusinessesDTOList;
//     }