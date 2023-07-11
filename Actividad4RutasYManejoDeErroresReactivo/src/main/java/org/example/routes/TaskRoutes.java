package org.example.routes;


import org.example.repository.model.ToDo;
import org.example.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskRoutes {

    @Autowired
    private ToDoService service;

    @Bean
    public RouterFunction<ServerResponse> getTasks(){
        return route(GET("route/get/all"),
                request -> ServerResponse
                        .ok()
                        .body(BodyInserters.fromPublisher(service.getTasks(), ToDo.class)));
    }

    //Generar un tres router functions
    //Post para guardar una tarea
    @Bean
    RouterFunction<ServerResponse> saveTask(){
        return  route(POST("route/createTask/{task}"),
                request -> ServerResponse.ok()
                        .body(BodyInserters
                                .fromPublisher(service.addTask(request.pathVariable("task")),ToDo.class )));
    }
    //Put para actualizar
    //Delete para eliminar una tarea.


}
