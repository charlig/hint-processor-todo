package com.hint.processor.todo.app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends ListCrudRepository<Todo, Long>, PagingAndSortingRepository<Todo, Long> {

//    Todo findByIdAndUserId(Long id,String userId);
//    boolean existsByIdAndUserId(Long id,String userId);
//
//    Page<Todo> findByUserId(String userId, PageRequest pageRequest);
}
