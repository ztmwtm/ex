package com.example.ex.controller;

import com.example.ex.model.Question;
import com.example.ex.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestController {

    private final QuestionService questionService;

    public JavaQuestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addJavaQuestion(@RequestParam("question") String question,
                                    @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeJavaQuestion(@RequestParam("question") String question,
                                    @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping(path = "")
    public Collection<Question> addJavaQuestion() {
        return questionService.getAll();
    }
}
