package com.lingo.tutor.repository;

import com.lingo.tutor.model.Lesson;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {


    List<Lesson> findAllByStudent(Integer student);

    List<Lesson> findAllByTutor(Integer tutor);


    @Modifying
    @Query("UPDATE lesson SET date_time = :dateTime WHERE id = :id")
    void updateDateTime(Integer id, LocalDateTime dateTime);
}
