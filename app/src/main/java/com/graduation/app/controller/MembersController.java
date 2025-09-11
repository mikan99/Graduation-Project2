package com.graduation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.form.MembersForm;
import com.graduation.app.service.MembersService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MembersController{

    @Autowired
    private MembersService membersService;

    // 初期表示
    @GetMapping("/")
    public String search(MembersForm form, Model model){
        model.addAttribute("membersForm", form);
        // 全件取得
        List<MembersDTO> membersList = membersService.sortMembers(form);
        model.addAttribute("membersList", membersList);

        return "index";
    }

    // 検索結果
    @PostMapping("/")
    public String postSearch(@Validated MembersForm form, BindingResult bindingResult, Model model){
        List<MembersDTO> membersList = membersService.sortMembers(form);
        // 入力エラーチェック
        if(bindingResult.hasErrors()){

        }
        else{

        }
        model.addAttribute("membersForm", form);
        model.addAttribute("membersList", membersList);
        
        return "index";
    }

    // ボタンで自販機使用回数を増やすAPI
    // @PostMapping("/increment")
    // @ResponseBody //viewではなくjsonを返すという設定
    // public ResponseEntity<Integer> incrementValue(@RequestParam(name = "id", required = false) Integer id){
    //     try{
    //         // サービスで値を増やしてDBを更新
    //         int newValue = membersService.incrementVendingMachine(id.intValue());
    //         return ResponseEntity.ok(newValue);
    //     }
    //     catch(Exception e){
    //         return ResponseEntity.badRequest().build();
    //     }
    // }

    @PostMapping("/increment")
    @ResponseBody
    public ResponseEntity<Integer> incrementValue(HttpServletRequest request) {
    System.out.println("id = " + request.getParameter("id"));
    return ResponseEntity.ok(123);
}


}