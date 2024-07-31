package com.example.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_list.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
