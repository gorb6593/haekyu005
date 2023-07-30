package haekyu005;

import haekyu005.answer.Answer;
import haekyu005.answer.AnswerRepository;
import haekyu005.question.Question;
import haekyu005.question.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AnswerRepositoryTests {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    private int lastSampleDataId;


    @BeforeEach
    void beforeEach() {
        clearData();
        createSampleData();
    }

    private void createSampleData() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);
    }

    private void clearData() {
        questionRepository.truncate();
        answerRepository.truncate();
    }

    @Test
    void 저장() {
        Question q = this.questionRepository.findById(2L).get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다2.");
        a.setQuestion(q);

        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }

    @Test
    void 조회() {
        Optional<Answer> oa = this.answerRepository.findById(1L);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }


}