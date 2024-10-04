package com.mensageriakafka.model;

public class Notification {
    private String message;
    private String priority; // "high" ou "low"
    private String userType; // "student", "teacher" ou "admin"

    // Construtores
    public Notification() {}

    public Notification(String message, String priority, String userType) {
        this.message = message;
        this.priority = priority;
        this.userType = userType;
    }

    // Getters e Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
