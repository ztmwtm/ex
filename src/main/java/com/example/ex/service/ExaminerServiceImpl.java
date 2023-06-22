package com.example.ex.service;

import com.example.ex.exception.IncorrectAmountException;
import com.example.ex.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (size < amount || amount <= 0) {
            throw new IncorrectAmountException(String.format("Sorry your amount %d is wrong amount must be > 0 and <= %d", amount, size));
        }
        Set<Question> result = new HashSet<>(amount);

        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return new ArrayList<>(result);
    }
}
