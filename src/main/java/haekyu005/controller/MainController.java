package haekyu005.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @RequestMapping("/sbb")
    /*
    아래 함수으 리턴값을 그대로 브라우저에 표시
    아래 함수의 리턴값을 문자열화 해서 부라우저 응답을 바디에 담는다
     */
    @ResponseBody
    public String index(){
        return "안녕하셈2.";
    }
    
    @GetMapping("/page1")
    @ResponseBody
    public String showGet(){
        return """
                  <form method="POST" action="/page2" />
                     <input type="number" name="age" placeholder="나이 입력" />
                     <input type="submit" value="page2로 POST 방식으로 이동" />
                  </form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String showPage2Post(@RequestParam(defaultValue = "0") int age){
        return """
                <h1>입력된 나이 : %d</h1>
           <h1>안녕하세요. POST 방식으로 오신걸 환영합니다.</h1>
           """.formatted(age);
    }

    @GetMapping("/page2")
    @ResponseBody
    public String showPost(@RequestParam(defaultValue = "0") int age){
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>get으로 왔니?</h1>
                """.formatted(age);
    }

    @GetMapping("/addArticle")
    @ResponseBody
    public String addArticle(String title, String body) {
        int id = 1;
        Article article = new Article(id, title, body);

        return "%d번 게시물이 생성되었습니다.".formatted(id);
    }

    @AllArgsConstructor
    class Article {
        private int id;
        private String title;
        private String body;
    }
}
