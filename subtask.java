# This is the subtask for the given assignment


package openin.assignment.model;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subtasks")

public class subtask {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "task_id", nullable = false)
	    private Task task;

	    private int status;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name = "created_at")
	    private Date createdAt;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name = "updated_at")
	    private Date updatedAt;

	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name = "deleted_at")
	    private Date deletedAt;

	    
	    public SubTask() {
	       

	    public SubTask(Task task, int status) {
	        this.task = task;
	        this.status = status;
	        
	    }

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Task getTask() {
	        return task;
	    }

	    public void setTask(Task task) {
	        this.task = task;
	    }

	    public int getStatus() {
	        return status;
	    }

	    public void setStatus(int status) {
	        this.status = status;
	    }

	    public Date getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(Date createdAt) {
	        this.createdAt = createdAt;
	    }

	    public Date getUpdatedAt() {
	        return updatedAt;
	    }

	    public void setUpdatedAt(Date updatedAt) {
	        this.updatedAt = updatedAt;
	    }

	    public Date getDeletedAt() {
	        return deletedAt;
	    }

	    public void setDeletedAt(Date deletedAt) {
	        this.deletedAt = deletedAt;
	    }

	    @Override
	    public String toString() {
	        return "SubTask{" +
	                "id=" + id +
	                ", task=" + task +
	                ", status=" + status +
	                ", createdAt=" + createdAt +
	                ", updatedAt=" + updatedAt +
	                ", deletedAt=" + deletedAt +
	                
	                '}';
	    }	
	
}
