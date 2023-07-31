package haekyu005;

import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class QuestionRepositoryTests {
//    @Autowired
//    private QuestionRepository questionRepository;
//    private static Long lastSampleDataId;
//
//    @BeforeEach
//    void beforeEach() {
//        clearData();
//        createSampleData();
//    }
//
//    private void createSampleData() {
//
//    }
//    public static void createSampleData(QuestionRepository questionRepository) {
//        createSampleData(questionRepository);
//    }
//    private void clearData() {
//        clearData(questionRepository);
//    }
//    private static void clearData(QuestionRepository questionRepository) {
//        questionRepository.truncate();
//    }
//
//    @Test
//    void 저장() {
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        questionRepository.save(q1);
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        questionRepository.save(q2);
//
//        assertThat(q1.getId()).isEqualTo(lastSampleDataId + 1);
//        assertThat(q2.getId()).isEqualTo(lastSampleDataId + 2);
//    }
//
//    @Test
//    void 삭제() {
//        assertThat(questionRepository.count()).isEqualTo(lastSampleDataId);
//        Question q = questionRepository.findById(1L).get();
//        questionRepository.delete(q);
//
//        assertThat(questionRepository.count()).isEqualTo(lastSampleDataId - 1);
//    }
//
//    @Test
//    void 수정() {
//        assertThat(questionRepository.count()).isEqualTo(lastSampleDataId);
//        Question q = questionRepository.findById(1L).get();
//        q.setSubject("수정된 제목!!");
//        questionRepository.save(q);
//
//        q = questionRepository.findById(1L).get();
//        assertThat(q.getSubject()).isEqualTo("수정된 제목!!");
//
//    }
//
//    @Test
//    void createManySampleData() {
//
//        boolean run = true;
//        if(run == false) return;
//
//        IntStream.rangeClosed(3, 300).forEach(id -> {
//            Question q = new Question();
//            q.setSubject("%d번 질문".formatted(id));
//            q.setContent("%d번 질문의 내용".formatted(id));
//            q.setCreateDate(LocalDateTime.now());
//            questionRepository.save(q);
//        });
//    }


}