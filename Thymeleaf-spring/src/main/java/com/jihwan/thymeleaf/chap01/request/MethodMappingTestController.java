package com.jihwan.thymeleaf.chap01.request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// 처음
@Controller
public class MethodMappingTestController {
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        /*
         * Model 객체에 addAttribute 메서드를 이용한다
         * key value 를 추가하면 추후 view에서 사용할 수 있다.
         **/
        model.addAttribute("message", "신규메뉴 등록 핸들러 메소드");
        /*
         * 반환하고자 하는 view의 경로를 포함한 이름을 작성한다.
         * 기본 경로는 resources/teplates 하위 경로를 시작한다.
         * */
        return "request/mappingResult";
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {
        model.addAttribute("message", "get 방식의 메뉴 핸들러 호출");
        return "request/mappingResult";
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
    public String modifyPostMenu(Model model) {
        // 유효성 검사
        // 서비스 호출
        // 응답
        model.addAttribute("message", "POST 방식의 메뉴 핸들러 호출");
        return "request/mappingResult";
    }


    /*
     * 요청 메소드 전용 어노테이션
     * 요청 메소드      어노테이션
     * post            @PostMapping
     * get             @GetMapping
     * put             @PutMapping
     * Delete          @DeleteMapping
     * patch           @PatchMapping
     * 각각의 어노테이션은 @RequestMapping 어노테이션 method속성을 사용하여 요청 방법을 지정한다.
     * 각 어노테이션은 해당 요청 메소드에 대해서만 처리할 수 있도록 제안하는 역할을 한다.
     * */

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "get 방식 삭제용 핸들러");
        return "request/mappingResult";
    }

    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "post 방식 삭제");
        return "request/mappingResult";
    }
}
