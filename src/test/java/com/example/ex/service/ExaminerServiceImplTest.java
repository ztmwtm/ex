package com.example.ex.service;

import com.example.ex.exception.IncorrectAmountException;
import com.example.ex.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> questions = new ArrayList<>();

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(questionServiceMock);
        questions.add(new Question("question1", "answer1"));
        questions.add(new Question("question2", "answer2"));
        questions.add(new Question("question3", "answer3"));
        Mockito.when(questionServiceMock.getAll()).thenReturn(questions);
        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"));
    }

    @Test
    void getQuestions() {
        assertThatThrownBy(() -> examinerService.getQuestions(0)).isInstanceOf(IncorrectAmountException.class);
        assertThatThrownBy(() -> examinerService.getQuestions(-1)).isInstanceOf(IncorrectAmountException.class);
        assertThatThrownBy(() -> examinerService.getQuestions(999)).isInstanceOf(IncorrectAmountException.class);
        assertThat(examinerService.getQuestions(3)).isNotNull().isEqualTo(questions);

    }
}