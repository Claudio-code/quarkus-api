package com.example.quarkusapi.rest.dto;

public record CreateUserRequest(String name, Integer age) {
    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
