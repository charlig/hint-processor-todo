package com.hint.processor.todo.app;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.lang.Nullable;

@SpringBootApplication
@RegisterReflectionForBinding({TodoDto.class, UserDto.class})
@ImportRuntimeHints(HintProcessorTodoApplication.Hints.class)
public class HintProcessorTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HintProcessorTodoApplication.class, args);
	}

	static class Hints implements RuntimeHintsRegistrar {
		@Override
		public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
			hints.resources().registerPattern("todo-banner.txt");
		}
	}

}
