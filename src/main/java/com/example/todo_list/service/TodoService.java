package com.example.todo_list.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.todo_list.entity.Todo;
import com.example.todo_list.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // podemos injetar dependências via atributo, método ou construtor
    // a via construtor não necessita o @Autowired, e é mais recomendada
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /*
     * vamos usar tudo em uma tela só
     * facilita a integração com front-end
     * todas as nossas operações retornarão uma lista todo
     */

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);

        /*
         * ao invés de chamar o 'findAll' novamente, retornamos o método de listagem já
         * criado
         */

        return list();
    }

    public List<Todo> list() {
        // cria uma consulta que ordena a lista por prioridade, depois por nome
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        // retorna a consulta
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    // APIs com deleção só é passado o ID
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }
}
