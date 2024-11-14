package com.ohgiraffers.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* comment.
*   AOP 기능 중 Advice 는 반복적으로 동작해야 할
*   코드들을 뭉쳐둔 메소드를 의미하는 단어이다.
*   ControllerAdvice 어노테이션은 마찬가지로
*   공통적으로 발생하는 예외처리를 담당하는 어노테이션을 의미한다.*/
@ControllerAdvice
public class GlobalExceptionHandler {

    /* comment.
    *   @ExceptionHandler 의 우선순위는
    *   해당클래스에 핸들러가 있으면 클래스 레벨이 우선순위를
    *   가지게 된다.
    *   만약 해당 클래스에 핸들러가 없으면 이후 전역의 핸들러를 동작시키게 된다.*/

    @ExceptionHandler(NullPointerException.class)
    public String globalNull(NullPointerException exception){
        System.out.println("전역 레벨의 exception 처리");

        return "error/nullPointer";
    }
}
