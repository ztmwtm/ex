package com.example.ex.service;

import com.example.ex.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
