package com.example.ex.service;

import com.example.ex.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
