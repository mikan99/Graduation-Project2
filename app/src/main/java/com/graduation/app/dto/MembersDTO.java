package com.graduation.app.dto;

import lombok.Data;

@Data
public class MembersDTO {
    private int id;
    private String memberName;
    private String sex;
    private Integer employeeNumber;
    private String bumonName;
    private Integer vendingMachine;

    public String getSexLabel(){
        if("0".equals(sex)) return "男性";
        if("1".equals(sex)) return "女性";
        if("2".equals(sex)) return "その他";
        return "";
    }
}
