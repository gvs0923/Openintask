# This is the controller task for the subtask.


package openin.assignment.controller;


import com.example.taskmanager.model.SubTask;
import com.example.taskmanager.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/subtasks")

public class subcontroller {

	
	  @Autowired
	    private SubTaskService subTaskService;

	    
	    @PostMapping
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> createSubTask(@Valid @RequestBody SubTask subTask,
	                                           @RequestHeader("Authorization") String token) {
	        try {
	            Long userId = extractUserIdFromToken(token);
	            SubTask createdSubTask = subTaskService.createSubTask(subTask, userId);
	            return new ResponseEntity<>(createdSubTask, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }

	    
	    @GetMapping
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<List<SubTask>> getAllUserSubTasks(@RequestParam(required = false) Long taskId,
	                                                            @RequestParam(defaultValue = "0") int page,
	                                                            @RequestParam(defaultValue = "10") int size,
	                                                            @RequestHeader("Authorization") String token) {
	        try {
	            Long userId = extractUserIdFromToken(token);
	            List<SubTask> subTasks = subTaskService.getAllUserSubTasks(userId, taskId, page, size);
	            return new ResponseEntity<>(subTasks, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	   
	    private Long extractUserIdFromToken(String token) {
	        return jwtTokenProvider.getUserIdFromToken(token.substring(7));
	    }
	
}
