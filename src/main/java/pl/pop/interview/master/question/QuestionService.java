package pl.pop.interview.master.question;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PostConstruct
    private void saveBasicQuestions() {
        if (questionRepository.count() == 0) {
            questionRepository.saveAll(createBasicQuestions());
        }
    }

    private List<Question> createBasicQuestions(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Czy w Javie istnieje wielokrotne dziedziczenie klas?", YesNo.NO));
        questions.add(new Question("Czy można utworzyć obiekt klasy abstrakcyjnej w Javie?", YesNo.NO));
        questions.add(new Question("Czy w Javie istnieje automatyczne zbieranie śmieci", YesNo.YES));
        questions.add(new Question("Czy interfejs w Javie może zawierać implementacje metod?", YesNo.YES));
        questions.add(new Question("Czy w Javie można nadpisywać metody statyczne?", YesNo.NO));
        questions.add(new Question("Czy Javę można używać do programowania na platformie Android?", YesNo.YES));
        questions.add(new Question("Czy Javie można przekazywać argumenty do metody przez referencję?", YesNo.NO));
        questions.add(new Question("Czy w Javie można obsługiwać wielowątkowość?", YesNo.YES));
        questions.add(new Question("Czy w Javie można dziedziczyć po więcej niż jednej klasie?", YesNo.NO));
        questions.add(new Question("Czy Javie można używać do tworzenia aplikacji webowych?", YesNo.YES));
        return questions;
    }

    public void addNewQuestion(QuestionDTO questionDTO) {
        Question question = buildQuestionFromDTO(questionDTO);
        questionRepository.save(question);
    }

    private Question buildQuestionFromDTO(QuestionDTO questionDTO) {
        return new Question(
                questionDTO.getContent(),
                questionDTO.getCorrectAnswer()
        );
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> listFromDB = questionRepository.findAll();

        return listFromDB.stream()
                .map( question -> new QuestionDTO( question.getContent(), question.getCorrectAnswer() ) )
                .toList();
    }


}
