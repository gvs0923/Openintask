#THis is the user task code.

package openin.assignment.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")

public class user {
	
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    @Column(name = "phone_number")
	    private String phoneNumber;

	    private int priority;

	    // Constructors
	    public User() {
	        // Default constructor
	    }

	    public User(String phoneNumber, int priority) {
	        this.phoneNumber = phoneNumber;
	        this.priority = priority;
	        
	    }

	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public int getPriority() {
	        return priority;
	    }

	    public void setPriority(int priority) {
	        this.priority = priority;
	    }

	    

	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", phoneNumber='" + phoneNumber + '\'' +
	                ", priority=" + priority +
	                
	                '}';
	    }
	

}
