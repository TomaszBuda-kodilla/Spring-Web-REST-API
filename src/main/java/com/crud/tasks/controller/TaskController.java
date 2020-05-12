package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private DbService service;
    @Autowired

    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET,  value = "getTasks")
    public List<TaskDto> getTasks(){
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(Long taskId){
        return new TaskDto(1L,"test title","test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(Long taskId){

    }
    @RequestMapping(method = RequestMethod.PATCH, value = "updateTask")
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto(1L,"Edited test title","Test content");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "createTask" )
    public TaskDto createTask(TaskDto taskDto){
        return new TaskDto(1L,"test1","test1");
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOneTask")
    @ResponseBody
    public List<TaskDto> getOneTask(@RequestParam("id") long id){
        return taskMapper.mapToTaskDtoList(service.getOne(id));
    }
}
