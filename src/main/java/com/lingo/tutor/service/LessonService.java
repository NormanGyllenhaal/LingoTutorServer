package com.lingo.tutor.service;

import com.lingo.tutor.model.Lesson;
import com.lingo.tutor.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;


    public List<Lesson> findLessonByStudent(Integer student) {
        return lessonRepository.findAllByStudent(student);
    }

    public List<Lesson> findLessonByTutor(Integer tutor) {
        return lessonRepository.findAllByTutor(tutor);
    }


    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Lesson lesson) {
        lessonRepository.updateDateTime(lesson.getId(), lesson.getDateTime());
        return lessonRepository.findById(lesson.getId()).get();
    }

    public void deleteLesson(Integer id) {
        lessonRepository.deleteById(id);
    }
}
