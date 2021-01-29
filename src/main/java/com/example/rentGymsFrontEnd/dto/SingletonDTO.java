package com.example.rentGymsFrontEnd.dto;


public class SingletonDTO<T> {
    private T content;


    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

