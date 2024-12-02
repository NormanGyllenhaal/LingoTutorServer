package com.lingo.tutor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    private Integer id;
    private String firebaseId;
    private String name;
    private String details;
    private Double price;
    private Integer lessons;
    private String avatar;
    private Integer role;
    private String messageToken;
    private String language;


}
