package com.lingo.tutor.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.lingo.tutor.model.User;
import com.lingo.tutor.model.UserMessage;
import com.lingo.tutor.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Slf4j
public class MessageService {

    @Autowired
    private UserRepository userRepository;

    public void sendMessage(UserMessage userMessage) {
        User user = userRepository.findById(userMessage.getDestinationId()).get();
        User source = userRepository.findById(userMessage.getSourceId()).get();
        Message message = Message.builder()
                .setToken(user.getMessageToken()) // Recipient's FCM token
                .setNotification(Notification.builder()
                        .setTitle(userMessage.getTitle())
                        .setBody(userMessage.getContent())
                        .setImage(source.getAvatar())
                        .build()).putData("sourceId", source.getId().toString())
                .build();
        try {
            String response = FirebaseMessaging.getInstance().send(message);
            log.info("Successfully sent message: " + response);
        } catch (Exception e) {
            log.info("Error sending message: " + e.getMessage());
        }
    }


    @PostConstruct
    public void initializeFirebase() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("firebase-message.json");
        byte[] binaryData = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
        InputStream serviceAccount = new ByteArrayInputStream(binaryData);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://lingo-tutor-default-rtdb.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);
    }


}
