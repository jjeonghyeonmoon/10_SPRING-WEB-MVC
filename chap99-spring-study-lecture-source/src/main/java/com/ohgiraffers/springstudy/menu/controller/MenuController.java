package com.ohgiraffers.springstudy.menu.controller;


import com.ohgiraffers.springstudy.menu.model.dto.MenuDTO;
import com.ohgiraffers.springstudy.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu/*")
public class MenuController {
    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;


    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource){
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("list")
    public String menuAllSelect(Model model){

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList",menuList);
        
        for(MenuDTO menuDTO : menuList) {
            System.out.println("menuDTO = " + menuDTO);
        }
        return "menu/list";

    }

}
