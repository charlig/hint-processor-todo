package com.hint.processor.todo.app;

import org.apache.catalina.User;

public record TodoDto(Long id, String todo, Boolean completed, UserDto user) {
    @Override
    public String toString() {
        return user().id();
    }
}
