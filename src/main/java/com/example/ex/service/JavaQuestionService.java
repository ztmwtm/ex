package com.example.ex.service;

import com.example.ex.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService {

    private List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        Question freshQuestion = new Question(question, answer);
        add(freshQuestion);
        return freshQuestion;
    }

    @Override
    public Question add(Question question) {
        if (isNotPresentedQuestion(question)) {
            questions.add(question);
        }
        return question;
    }

    private boolean isNotPresentedQuestion(Question question) {
        return questions.stream().map(Question::getQuestion).noneMatch(s -> s.equals(question.getQuestion()));
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(ThreadLocalRandom.current().nextInt(questions.size()));
    }
}
