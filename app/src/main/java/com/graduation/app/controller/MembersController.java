package com.graduation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.form.MembersForm;
import com.graduation.app.service.MembersService;

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
        // 入力エラーチェック
        if(bindingResult.hasErrors()){
            List<MembersDTO> membersList = membersService.getAllMembers(); // 全件検索
            model.addAttribute("membersForm", form);
            model.addAttribute("membersList", membersList);

            return "index";
        }
        else{
            List<MembersDTO> membersList = membersService.sortMembers(form); // 条件付き検索
            model.addAttribute("membersForm", form);
            model.addAttribute("membersList", membersList);
            
            return "index";
        }
    }

    // ボタンで自販機使用回数を増やすAPI
    @PostMapping("/members/{id}/increment")
    @ResponseBody
    public ResponseEntity<Integer> incrementValue(@PathVariable Long id) {
        int newCount = membersService.incrementVendingMachine(id); // Serviceを呼んで +1 更新
        return ResponseEntity.ok(newCount); // 新しい値を返す（JS側で画面に反映）
    }

    @PostMapping("/members/{id}/decrement")
    @ResponseBody
    public ResponseEntity<Integer> decrementValue(@PathVariable Long id) {
        int newCount = membersService.decrementVendingMachine(id);
        return ResponseEntity.ok(newCount);
    }

}