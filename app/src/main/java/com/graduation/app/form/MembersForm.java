package com.graduation.app.form;

import lombok.Data;

@Data
public class MembersForm {
    
    //氏名
    private String memberName;

    //性別
    private Integer sex;

    //社員番号
    private Integer employeeNumber;

    //配属先
    private String bumonName;

    //おごり自販機使用回数
    private Integer vendingMachine;

}
