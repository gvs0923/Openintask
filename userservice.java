package openin.assignment.service;


import com.example.taskmanager.exception.ResourceNotFoundException;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class userservice {
	
	
	 @Autowired
	    private UserRepository userRepository;

	    public User getUserById(Long userId) {
	        
	        return userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
	    }

	    public List<User> getAllUsers() {
	      
	        return userRepository.findAll();
	    }

	    public User updateUser(Long userId, User updatedUser) {
	       
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

	        user.setPhoneNumber(updatedUser.getPhoneNumber());
	        user.setPriority(updatedUser.getPriority());
	        

	        return userRepository.save(user);
	    }

	    public void deleteUser(Long userId) {
	        
	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

	        userRepository.delete(user);
	    }
	
	
	
	
	
	
	
	
	
	
	

}
