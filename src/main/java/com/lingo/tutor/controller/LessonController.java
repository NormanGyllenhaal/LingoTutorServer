package com.lingo.tutor.controller;

import com.lingo.tutor.model.Lesson;
import com.lingo.tutor.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<Lesson> getLessons(@RequestParam(value = "student", required = false) Integer student,
                                   @RequestParam(value = "tutor", required = false) Integer tutor) {
        if (tutor != null) {
            return lessonService.findLessonByTutor(tutor);
        }
        if (student != null) {
            return lessonService.findLessonByStudent(student);
        }
        return new ArrayList<>();
    }


    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @PutMapping
    public Lesson updateLesson(@RequestBody Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Integer id) {
        lessonService.deleteLesson(id);
    }
}
