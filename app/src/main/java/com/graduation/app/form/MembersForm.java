package com.graduation.app.form;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MembersForm {
    
    //氏名
    @Size(max = 30, message = "「 氏名 」は30文字以内で入力してください")
    private String memberName;

    //性別
    private String sex;

    //社員番号
    @Size(max = 10, message = "「 社員番号 」は10桁以内で入力してください")
    private String employeeNumber;

    //配属先
    @Size(max = 30, message = "「 配属先 」は30文字以内で入力してください")
    private String bumonName;

    //おごり自販機使用回数
    private Integer vendingMachine;

}
