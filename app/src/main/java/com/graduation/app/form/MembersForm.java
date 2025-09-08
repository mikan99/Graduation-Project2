package com.graduation.app.form;

import lombok.Data;

@Data
public class MembersForm {
    
    //氏名
    private String memberName;

    //性別
    private int sex;

    //社員番号
    private int employeeNumber;

    //配属先
    private String bumonName;

}
