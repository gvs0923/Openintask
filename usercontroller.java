#This is the code for the user controller.

package openin.assignment.controller;


import com.example.taskmanager.model.User;
import com.example.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")

public class usercontroller {
	
	
	  @Autowired
	    private UserService userService;

	    
	    @GetMapping("/{userId}")
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> getUser(@PathVariable Long userId) {
	        try {
	            User user = userService.getUserById(userId);
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }

	   
	    @PutMapping("/{userId}")
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
	        try {
	            User user = userService.updateUser(userId, updatedUser);
	            return new ResponseEntity<>(user, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
	    }

	   
	    @DeleteMapping("/{userId}")
	    @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
	        try {
	            userService.deleteUser(userId);
	            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        }
      }
}
  
