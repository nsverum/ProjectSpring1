package com.test;

import org.domain.Application;
import org.domain.model.Status;
import org.domain.model.Task;
import org.domain.service.TaskService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Application.class, TaskService.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTest {
    @Autowired
    public TaskService taskService;
    private static Long id;

    @Test
    @Order(1)
    public void whenTaskSavingThenCanGetTaskById(){
        Task task = new Task();
        task.setDescription("testDescription");
        task.setStatus(Status.DONE);
        taskService.saveTask(task);
        assertNotEquals(task.getId(),0);
        id = task.getId();
        System.out.println("ID = " + id);
        Task taskFromDB = taskService.getTaskById(task.getId());
        assertEquals(task.getDescription(),"testDescription");
        assertEquals(task.getStatus(),Status.DONE);

    }
    @Test
    @Order(2)
    public void whenTaskSavedCanDeleted(){
      taskService.deleteTaskById(id);
      RuntimeException runtimeException =
                  assertThrows(RuntimeException.class, () -> taskService.getTaskById(id));
      assertEquals(runtimeException.getMessage(), " Task not found for id: " + id);

    }
}
