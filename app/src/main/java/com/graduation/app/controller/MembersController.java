package com.graduation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.form.MembersForm;
import com.graduation.app.service.MembersService;

@Controller
public class MembersController{

    @Autowired
    private MembersService membersService;

    @GetMapping("/")
    public String search(MembersForm form, Model model){
        model.addAttribute("membersForm", form);

        List<MembersDTO> membersList = membersService.sortMembers();
        model.addAttribute("membersList", membersList);

        return "index";
    }

    // ボタンで自販機使用回数を増やすAPI
    // --------------------------------------------------------------------------------------
    // @PostMapping("/increment")
    // @ResponseBody
    // public ResponseEntity<Integer> incrementValue(@RequestParam Integer id){
    //     try{
    //         // サービスで値を増やしてDBを更新
    //         int newValue = membersService.incrementVendingMachine(id.intValue());
    //         return ResponseEntity.ok(newValue);
    //     }
    //     catch(Exception e){
    //         return ResponseEntity.badRequest().build();
    //     }
    // }
    // --------------------------------------------------------------------------------------

}