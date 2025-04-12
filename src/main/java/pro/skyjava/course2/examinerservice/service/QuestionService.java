package pro.skyjava.course2.examinerservice.service;

import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {
    //В нем должны быть методы работы с вопросами определенного предмета: хмм поиск ответа по вопросу, возврат всех В/О, и просто В

    String getAnswer(String question);

    Collection<Question> getAll();
}
