package com.graduation.app.form;

import jakarta.validation.constraints.Max;
import lombok.Data;

@Data
public class MembersForm {
    
    //氏名
    @Max(value = 30, message = "氏名は30文字以内で入力してください")
    private String memberName;

    //性別
    private String sex;

    //社員番号
    @Max(value = 10, message = "社員番号は10桁以内で入力してください")
    private Integer employeeNumber;

    //配属先
    @Max(value = 30, message = "配属先は30文字以内で入力してください")
    private String bumonName;

    //おごり自販機使用回数
    private Integer vendingMachine;

}
