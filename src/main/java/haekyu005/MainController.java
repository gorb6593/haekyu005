package haekyu005;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private List<Article> articles = new ArrayList<>(
            Arrays.asList(
                    new Article("제목", "내용"),
                    new Article("제목", "내용")
            )
    );

    @GetMapping("/addArticle")
    @ResponseBody
    public String addArticle(String title, String body) {
        Article article = new Article(title, body);
        articles.add(article);

        return "%d번 게시물이 생성되었습니다.".formatted(article.getId());
    }

    @GetMapping("/article/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable int id) {

        Article article = articles // id가 1번인 게시물이 앞에서 3번째
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);

        return article;
    }
    @GetMapping("/modifyArticle/{id}")
    @ResponseBody
    public String modifyArticle(@PathVariable int id, String title, String body) {

        Article article = articles // id가 1번인 게시물이 앞에서 3번째
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);

        if(article == null) {
            return "%d번 게시물은 존재하지 않습니다.".formatted(id);
        }

        article.setTitle(title);
        article.setBody(body);

        return "%d번 게시물을 수정하였습니다.".formatted(article.getId());
    }

    @GetMapping("/deleteArticle/{id}")
    @ResponseBody
    public String deleteArticle(@PathVariable int id) {

        Article article = articles
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);

        if(article == null) {
            return "%d번 게시물은 존재하지 않습니다.".formatted(id);
        }

        articles.remove(article);

        return "%d번 게시물을 삭제하였습니다.".formatted(article.getId());
    }

    @AllArgsConstructor
    @Getter
    @Setter
    class Article {
        private static int lastId = 0;

        private int id;
        private String title;
        private String body;

        public Article(String title, String body) {
            this(++lastId, title, body);
        }
    }
}
