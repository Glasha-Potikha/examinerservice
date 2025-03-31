package pro.skyjava.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.service.JavaQuestionService;
import pro.skyjava.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
//Он должен позволять пользователю добавлять, просматривать и удалять вопросы по Java.

    private final JavaQuestionService service;

    JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    //по ссылке: http://localhost:8080/exam/java/add?question=QuestionText&answer=QuestionAnswer
    @GetMapping("/add")
    Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    //по ссылке: http://localhost:8080/exam/java
    @GetMapping
    Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/test")
    Collection<Question> getTestQuestions() {
        service.addTestQuestions();
        return service.getAll();
    }

    //по ссылке: http://localhost:8080/exam/java/remove?question=QuestionText&answer=QuestionAnswer
    @GetMapping("/remove")
    Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
}
