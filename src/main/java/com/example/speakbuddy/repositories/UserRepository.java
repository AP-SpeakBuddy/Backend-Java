package com.example.speakbuddy.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.example.speakbuddy.data_objects.AuthData;
import com.example.speakbuddy.data_objects.UserData;

/**
 * This class handles user data.
 */
@Repository
public class UserRepository {

    private List<UserData> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.loadData();
    }

    private void loadData() {
        String filePath = "data/users.json";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (inputStream == null) throw new IOException("File not found: " + filePath);
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                UserData user = new UserData(
                        jsonObject.getInt("id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("email"),
                        jsonObject.getString("birthDate"),
                        jsonObject.getString("languageSpoken"),
                        jsonObject.getString("languageLearning"),
                        jsonObject.getInt("writingLevel"),
                        jsonObject.getInt("readingLevel"),
                        jsonObject.getInt("speakingLevel"),
                        jsonObject.getInt("listeningLevel"),
                        jsonObject.getJSONArray("interests").toList().toArray(new String[0])
                );
                this.users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<UserData> getUserById(int id) {
        return users.stream().filter(user -> user.id == id).findFirst();
    }

    public Optional<UserData> authUser(AuthData authData) {
        return users.stream()
                .filter(user -> user.email.equals(authData.email))
                .findFirst();
    }

    public UserData addUser(UserData userData) {
        userData.id = users.size() + 1;
        users.add(userData);
        return userData;
    }
}
