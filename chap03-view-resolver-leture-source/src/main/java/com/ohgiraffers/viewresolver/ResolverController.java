package com.ohgiraffers.viewresolver;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {

    /* comment.
     *   핸들러 메소드에서 마지막으로 해야 할 일은
     *   client 에게 응답해야 할 페이지를 리턴하는 것이다.
     *   스프링에서는 다양한 전략에 맞게 뷰를 해석할 수 있는
     *   viewResolver 구현체가 존재한다.
     *   우리가 Thymeleaf 의존성을 추가하게 된다면
     *   뷰리졸버는 타임리프 문법을 해석할 수 있는
     *   ThymeleafViewResolver 로 전환이 되며
     *   이는 prefix 로 resource/templates/
     *   suffix 로 .html 을 자동으로 붙여주게 된다.*/
    @GetMapping("string")
    public String stringReturn(Model model){

        model.addAttribute("forwardMessage",
                           "문자열로 view 반환" );

        return "result";
    }
        @GetMapping("string-redirect")
        public String stringRedirect() {

        /* comment.
        *   우리가 지금까지 view 를 반환하는 방식은
        *   default 로 forward 방식이다.
        *   redirect 를 하는 방법은 접두사로 redirect: 를 붙이면 된다.
        *   */
                return "redirect:/";
        }

    /*comment.
     *  redirect 란, 최초 요청을 받게 되면 응답을 진행 후
     *   다시 재요청을 하는 방식이다.
     *   따라서 request 가 2번 일어나기 때문에 값을 유지
     *   할 방법이 없다.
     *   그래서 Servlet 에서 Session, Cookie 라는 개념을
     *   했었다.
     *   Session 과 Cookie 는 별도의 공간을 할당하기 때문에
     *   관리 할 데이터가 많아지면 서버의 부담이 생길 수 있다.
     *   스프링에서는 RedirectAttributes 라는 타입을 통해
     *   redirect 시 값을 저장할 수 있는 기능을 제공해준다.
     * */
        @GetMapping("string-redirect-attr")
    public String redirectAttr(RedirectAttributes attr){

           attr.addFlashAttribute("flashMessage",
                                 "리다이렉트 시 값 유지!!");

            return "redirect:/";
        }

        @GetMapping("modelandview")
        public ModelAndView modelAndViewReturn(ModelAndView mv){
            mv.addObject("forwardMessage",
                            "ModelAndView 를 이용해서 반환");
            mv.setViewName("result");

            return mv;
        }

        @GetMapping("modelandview-redirect-attr")
    public ModelAndView mvRedirectAttr(ModelAndView mv, RedirectAttributes attr) {

            attr.addFlashAttribute("flashMessage2",
                    "ModelAndView 리다이렉트 시 값유지!!!");
            mv.setViewName("redirect:/");

            return mv;

        }


}
