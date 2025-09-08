package com.graduation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.graduation.app.dto.MembersDTO;
import com.graduation.app.form.MembersForm;
import com.graduation.app.service.MembersService;

@Controller
public class MembersController{

    @Autowired
    private MembersService membersService;

    @GetMapping("/")
    public String search(MembersForm form, Model model){
        List<MembersDTO> membersList = membersService.sortMembers();
        model.addAttribute("membersList", membersList);

        return "index";
    }

}