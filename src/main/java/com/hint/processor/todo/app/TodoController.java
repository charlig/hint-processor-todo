package com.hint.processor.todo.app;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @GetMapping("/list")
    public String findAll(Model model) {
        List<TodoDto> todos = todoRepository.findAll().stream()
                .map(t -> new TodoDto(t.getId(), t.getTodo(),t.getCompleted(),  new UserDto(t.getUser()))).toList();
//        List<Todo> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todo-list.html";
    }

    @GetMapping("/banner")
    public String banner(Model model) throws IOException {
        ClassPathResource resource = new ClassPathResource("todo-banner.txt");
        String banner = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        model.addAttribute("banner", banner);
        return "banner.html";
    }
}
