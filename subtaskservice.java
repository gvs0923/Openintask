package openin.assignment.service;


import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.model.SubTask;
import com.example.taskmanager.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class subtaskservice {
	
	
	
	@Autowired
    private SubTaskRepository subTaskRepository;

    public SubTask createSubTask(SubTask subTask) {
       
        return subTaskRepository.save(subTask);
    }

    public List<SubTask> getSubTasksByTaskId(Long taskId) {
        
        return subTaskRepository.findByTaskId(taskId);
    }

    public SubTask updateSubTaskStatus(Long subTaskId, int status) {
       
        SubTask subTask = subTaskRepository.findById(subTaskId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTask not found with id: " + subTaskId));

        subTask.setStatus(status);
        return subTaskRepository.save(subTask);
    }

    public void deleteSubTask(Long subTaskId) {
      
        SubTask subTask = subTaskRepository.findById(subTaskId)
                .orElseThrow(() -> new ResourceNotFoundException("SubTask not found with id: " + subTaskId));

        subTaskRepository.delete(subTask);
    }

}
