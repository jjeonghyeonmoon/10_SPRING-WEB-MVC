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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

        return "menu/list";

    }

    @GetMapping("menuRegist")
    public String showRegistPage(){
        return "menu/menuRegist";
    }

    @PostMapping("menuRegist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO,RedirectAttributes rttr){
            menuService.registMenu(menuDTO);
        rttr.addFlashAttribute("successMessage","메뉴가 성공적으로 등록되었습니다.");

        return "redirect:/menu/list";
    }

    // 1. 업데이트 전체조회
    @GetMapping("menuList")
    public String findAllList(Model model){
        List<MenuDTO> menus = menuService.findAllMenus();

        model.addAttribute("menuList", menus);

        return "menu/menuList";
    }

    @GetMapping("showUpdate")
    public String showUpdateForm(@RequestParam("menuCode") int menuCode,Model model){

       MenuDTO menu = menuService.findMenuByCode(menuCode);
        model.addAttribute("menu",menu);

        return "menu/showUpdate";
    }
    // 3. 수정 처리
    @PostMapping("showUpdate")
    public String updateMenu(@ModelAttribute MenuDTO menuDTO, RedirectAttributes rttr) {
        menuService.updateMenu(menuDTO);
        rttr.addFlashAttribute("successMessage", menuDTO.getCode() + "번 메뉴가 수정되었습니다.");
        return "redirect:/menu/menuList"; // 수정 후 리스트 화면으로 리다이렉트
    }

}
