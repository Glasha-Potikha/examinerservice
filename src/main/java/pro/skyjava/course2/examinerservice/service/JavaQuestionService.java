package pro.skyjava.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.*;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (!questions.contains(q)) {
            questions.add(q);
        }
        return q;
    }

    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        }
        return question;
    }

    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
        }
        return question;
    }

    public Collection<Question> getAll() {
        Collection<Question> res = questions;
        return res;
    }

    public Question getRandomQuestion() {
        Question res = new Question("Вы видите этот вопрос?", "Значит преподаватель не успел заготовить вопросы");
        if (!questions.isEmpty()) {
            int i = new Random().nextInt(questions.size());
            Iterator<Question> iterator = questions.iterator();
            for (; i >= 0; i--) {
                res = iterator.next();
            }
        }//а если пустой..возвращаем "пустой" res
        return res;
    }

    public String getAnswer(String question) {

        Question q = new Question("пустой вопрос", "ответа у нас нет :(");
        String res = q.getAnswer();
        Iterator<Question> iterator = questions.iterator();
        while (iterator.hasNext()) {
            q = iterator.next();
            if (q.getQuestion().equals(question)) {
                res = q.getAnswer();
            }
        }
        return res;
    }

    public void addTestQuestions() {
        add("Как зовут смешарика кролика?", "Крош");
        add("Как зовут первого спутника в ньюскуле Доктора Кто?", "Роза");
        add("Как зовут голубовласую главную героиню Аркейна?", "Джинкс");
        add("Как зовут сестру Финеса и Ферба?", "Кендис");
        add("Как зовут падавана Энакина Скайвокера?", "Асока Тано");
        add("Как зовут злодейку в Коралине в стране кошмаров?", "Бельдам");
        add("Как зовут отца и мать главных героев из Сверхъестественного?", "Джон и Мэри");
        add("Как зовут главную героиню сериала Фаллаут 2024года", "Люси");
        add("Как зовут главного героя из Времени Приключений?", "Финн");
        add("Как зовут приёмного брата Гамбола из удивительного мира Гамбола?", "Дарвин");
    }
}

