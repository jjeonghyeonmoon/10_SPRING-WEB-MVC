package com.ohgiraffers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lecture/*")
public class LectureController {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv) {

        mv.addObject("member",new MemberDTO("조평훈",20,'남',"경기도수원시"));

        mv.addObject("hello","hi~<h2>타임리프</h2>");

        mv.setViewName("lecture/expression");


        return mv;
    }
}
