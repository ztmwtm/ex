package com.example.ex.service;

import com.example.ex.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Spy
    QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    private void setUp() {
        questionService.add(new Question("question1", "answer1"));
        questionService.add(new Question("question2", "answer2"));

    }

    @Test
    void addThenEqualsResultThenEqualsGetAll() {
        List<Question> expected = new ArrayList<>();
        expected.add(new Question("question1", "answer1"));
        expected.add(new Question("question2", "answer2"));
        expected.add(new Question("question3", "answer3"));
        assertThat(questionService.add("question3", "answer3"))
                .isEqualTo(new Question("question3", "answer3"));
        assertThat(questionService.getAll()).isNotNull().isEqualTo(expected);
    }

    @Test
    void addQuestionObjectThenEqualsResultThenEqualsGetAll() {
        List<Question> expected = new ArrayList<>();
        expected.add(new Question("question1", "answer1"));
        expected.add(new Question("question2", "answer2"));
        expected.add(new Question("question3", "answer3"));
        assertThat(questionService.add(new Question("question3", "answer3")))
                .isEqualTo(new Question("question3", "answer3"));
        assertThat(questionService.getAll()).isNotNull().isEqualTo(expected);
    }

    @Test
    void removeQuestionObjectThenEqualsResultThenEqualsGetAll() {
        List<Question> expected = new ArrayList<>();
        expected.add(new Question("question1", "answer1"));
        assertThat(questionService.remove(new Question("question2", "answer2")))
                .isEqualTo(new Question("question2", "answer2"));
        assertThat(questionService.getAll()).isNotNull().isEqualTo(expected);
    }

    @Test
    void getAll() {
        List<Question> expected = new ArrayList<>();
        expected.add(new Question("question1", "answer1"));
        expected.add(new Question("question2", "answer2"));
        assertThat(questionService.getAll()).isNotNull().isEqualTo(expected);
    }

    @Test
    void getRandomQuestion() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(new Question("randomQuestion", "randomAnswer"));
        assertThat(questionService.getRandomQuestion()).isNotNull().isEqualTo(new Question("randomQuestion", "randomAnswer"));
    }
}