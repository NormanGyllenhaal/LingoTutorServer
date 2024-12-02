package com.lingo.tutor.repository;

import com.lingo.tutor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void updateUser(User user) {
        StringBuilder sql = new StringBuilder("UPDATE user SET ");
        Map<String, Object> params = new HashMap<>();

        if (user.getName() != null) {
            sql.append("name = :name, ");
            params.put("name", user.getName());
        }
        if (user.getDetails() != null) {
            sql.append("details = :details, ");
            params.put("details", user.getDetails());
        }
        if (user.getFirebaseId() != null) {
            sql.append("firebase_id = :firebaseId, ");
            params.put("firebaseId", user.getFirebaseId());
        }
        if (user.getPrice() != null) {
            sql.append("price = :price, ");
            params.put("price", user.getPrice());
        }
        if (user.getLessons() != null) {
            sql.append("lessons = :lessons, ");
            params.put("lessons", user.getLessons());
        }
        if (user.getAvatar() != null) {
            sql.append("avatar = :avatar, ");
            params.put("avatar", user.getAvatar());
        }
        if (user.getRole() != null) {
            sql.append("role = :role, ");
            params.put("role", user.getRole());
        }
        if (user.getMessageToken() != null) {
            sql.append("message_token = :messageToken, ");
            params.put("messageToken", user.getMessageToken());
        }
        if (user.getLanguage() != null) {
            sql.append("language = :language, ");
            params.put("language", user.getLanguage());
        }
        // Remove the trailing comma and add WHERE clause
        sql.setLength(sql.length() - 2);  // Remove the last comma and space
        sql.append(" WHERE id = :id");
        params.put("id", user.getId());
        // Execute the update
        jdbcTemplate.update(sql.toString(), params);
    }
}
