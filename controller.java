package openin.assignment.controller;


import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/tasks")


public class Mycontroller {

	 @Autowired
	    private TaskService taskService;

	    
	    @PostMapping
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> createTask(@Valid @RequestBody Task task,
	                                        @RequestHeader("Authorization") String token) {
	        try {
	            Long userId = extractUserIdFromToken(token);
	            Task createdTask = taskService.createTask(task, userId);
	            return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }

	  
	    @GetMapping
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<List<Task>> getAllUserTasks(@RequestParam(required = false) String priority,
	                                                      @RequestParam(required = false) String dueDate,
	                                                      @RequestParam(defaultValue = "0") int page,
	                                                      @RequestParam(defaultValue = "10") int size,
	                                                      @RequestHeader("Authorization") String token) {
	        try {
	            Long userId = extractUserIdFromToken(token);
	            List<Task> tasks = taskService.getAllUserTasks(userId, priority, dueDate, page, size);
	            return new ResponseEntity<>(tasks, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	 
	    private Long extractUserIdFromToken(String token) {
	        return jwtTokenProvider.getUserIdFromToken(token.substring(7));
	    }
}
