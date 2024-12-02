package com.lingo.tutor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserMessage {

    private Integer sourceId;

    private Integer destinationId;

    private String title;

    private String content;
}
