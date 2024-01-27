# This is the method and the function called when the task is called.

package openin.assignment.service;


import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class taskservice {

	
	
	 @Autowired
	    private TaskRepository taskRepository;

	    public Task createTask(Task task) {
	        
	        return taskRepository.save(task);
	    }

	    public List<Task> getAllUserTasks(Long userId) {
	        
	        return taskRepository.findByUserId(userId);
	    }

	    public Task updateTask(Long taskId, Task updatedTask) {
	    
	        Task task = taskRepository.findById(taskId)
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

	        task.setTitle(updatedTask.getTitle());
	        task.setDescription(updatedTask.getDescription());
	        task.setDueDate(updatedTask.getDueDate());
	    

	        return taskRepository.save(task);
	    }

	    public void deleteTask(Long taskId) {
	      
	        Task task = taskRepository.findById(taskId)
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));

	        taskRepository.delete(task);
	    }
}

  
