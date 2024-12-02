package com.lingo.tutor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "lesson")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Lesson {

    @Id
    private Integer id;

    private Integer tutor;

    private Integer student;

    private String title;

    private String subtitle;

    private String description;

    private String picture;

    private LocalDateTime dateTime;
}
