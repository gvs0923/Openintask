# This contains the code for the subtask with the attributes.

  package openin.assignment.model;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "tasks")
public class task {
	
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    private String title;

	    @NotBlank
	    private String description;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name = "due_date")
	    private Date dueDate;

	    
	    public Task() {
	       
	    }

	    public Task(String title, String description, Date dueDate) {
	        this.title = title;
	        this.description = description;
	        this.dueDate = dueDate;
	       
	    }

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Date getDueDate() {
	        return dueDate;
	    }

	    public void setDueDate(Date dueDate) {
	        this.dueDate = dueDate;
	    }
	    @Override
	    public String toString() {
	        return "Task{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", description='" + description + '\'' +
	                ", dueDate=" + dueDate +
	                
	                '}';
      }
}
