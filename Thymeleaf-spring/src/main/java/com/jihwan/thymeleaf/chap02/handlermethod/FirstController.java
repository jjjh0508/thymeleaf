package com.jihwan.thymeleaf.chap02.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes("id")
public class FirstController {

    @GetMapping("regist")
    public void regist(){}

    @PostMapping("regist")
    public String registMenu(Model model , WebRequest request) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        String message = name + "을 신규 메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";

        System.out.println(message);
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }


    @GetMapping("login")
    public void login(){}

    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id) {
        session.setAttribute("id", id);
        return "first/loginResult";

    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session) {
        session.invalidate();
        return "first/loginResult";
    }

    @GetMapping("body")
    public void body() {
    }
    /*
    * 4-2 @SessionAttributes를 이용하여 session에 값 담기
    *   클래스 레벨에 @SessionArrtibutes 어노테이션을 이용해서 세션에 값을 담을 key 를 설정하여
    *  model 영역에 해당 key로 값이 추가되는 경우 session에 자동으로 등록한다.
    *
    * */

    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id) {
        System.out.println(id);
        model.addAttribute("id", id);
        return "first/loginResult";
    }
    //SessionAttributes로 등록된 값은 session의 상태를 관리하는 sessionStatus의 setComplate() 메소드를 호출해야 사용이 만료된다.
    @GetMapping("logout2")
    public String logout2Test(SessionStatus sessionStatus) {
        //세션을 전체 제거
        sessionStatus.setComplete();
        return "first/loginResult";
    }

    /*
     * 5.RequestBody를 이용하는 방법
     * 해당 어노테이션은 http 본문 자체를 읽는 부분을 모델로 변환 시켜주는 어노테이션이다.
     *
     * 출력을 해보면 쿼리스트링 형태의 문자열이 전송된다.
     *
     * json으로 전달하는 경우 jackson의 컨버터로 자동 파싱하여 사용할 수 있다.
     * 주로 RestAPI 작성시 많이 사용되며, 일반 적인 form 전송을 할 때는 거의 사용하지 않는다.
     *
     * 추가적으로 헤더의 대한 정보도
     * @RequestHeader 어농테이션을 이용해서 가져올 수있다.
     * @CookieValue를 이용해서 쿠키 정보도 쉽게 볼러올 수 있다.
     *
     * */
    @PostMapping("body")
    public void bodyTest(@RequestBody String body, @RequestHeader("content-type") String content,
                         @CookieValue(value = "JSESSIONID", required = false) String sessionId) {

        System.out.println(content);
        System.out.println(sessionId);
        System.out.println(body);
        System.out.println(URLDecoder.decode(body));
    }


}
