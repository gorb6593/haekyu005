package haekyu005;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

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

    }

    private void clearData() {
        questionRepository.disableForeignKeyCheck();
        answerRepository.truncate();
        questionRepository.enableForeignKeyCheck();
    }

    @Test
    void 저장() {
        Question q = this.questionRepository.findById(2).get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다2.");
        a.setQuestion(q);

        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }


}