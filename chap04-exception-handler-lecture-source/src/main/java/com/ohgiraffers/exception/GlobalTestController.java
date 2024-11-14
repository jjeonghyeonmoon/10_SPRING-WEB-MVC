package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class GlobalTestController {

    @GetMapping("global-nullpointer")
    public String globalNull() {
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }
}
