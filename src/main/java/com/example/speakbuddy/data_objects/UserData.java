package com.example.speakbuddy.data_objects;

/**
 * This class represents a user's data structure.
 */
public class UserData {
    public int id;
    public String name;
    public String email;
    public String birthDate;
    public String languageSpoken;
    public String languageLearning;
    public int writingLevel;
    public int readingLevel;
    public int speakingLevel;
    public int listeningLevel;
    public String[] interests;

    public UserData(int id, String name, String email, String birthDate, String languageSpoken, 
                    String languageLearning, int writingLevel, int readingLevel, int speakingLevel, 
                    int listeningLevel, String[] interests) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.languageSpoken = languageSpoken;
        this.languageLearning = languageLearning;
        this.writingLevel = writingLevel;
        this.readingLevel = readingLevel;
        this.speakingLevel = speakingLevel;
        this.listeningLevel = listeningLevel;
        this.interests = interests;
    }
}
