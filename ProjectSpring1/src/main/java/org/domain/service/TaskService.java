package org.domain.service;

import org.domain.model.Task;
import org.domain.repository.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    TaskDAO taskDAO;
    @Autowired
    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAllTask(){
        return taskDAO.findAll();
    }
    public void saveTask(Task task){
        taskDAO.save(task);
    }
    public void deleteTaskById(long id){
        taskDAO.deleteById(id);
    }
    public Task getTaskById(long id){
        Optional<Task> optionalTask = taskDAO.findById(id);
        if (optionalTask.isPresent()){
            return optionalTask.get();
        }
        throw  new RuntimeException(" Task not found for id: " + id);
    }
    public Page<Task> findPaginated(int pageNumber, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize,sort);
        return taskDAO.findAll(pageable);
    }



}
