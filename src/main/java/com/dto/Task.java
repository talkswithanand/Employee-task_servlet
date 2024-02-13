package com.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Task implements Comparable<Task>{
	
	public int compareTo(Task o) {
			return this.status.compareTo(o.status);
		}
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

private String description;
@CreationTimestamp
private LocalDateTime createdTaskTime;
@CreationTimestamp
private LocalDateTime completedTaskTime;
private String status;

@ManyToOne
@JoinColumn(name = "employeeId")
private UserInfo userInfo;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public LocalDateTime getCreatedTaskTime() {
	return createdTaskTime;
}

public void setCreatedTaskTime(LocalDateTime createdTaskTime) {
	this.createdTaskTime = createdTaskTime;
}

public LocalDateTime getCompletedTaskTime() {
	return completedTaskTime;
}

public void setCompletedTaskTime(LocalDateTime completedTaskTime) {
	this.completedTaskTime = completedTaskTime;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public UserInfo getUserInfo() {
	return userInfo;
}

public void setUserInfo(UserInfo userInfo) {
	this.userInfo = userInfo;
}

@Override
public String toString() {
	return "Task [id="+id+" ,description=" + description + ", createdTaskTime=" + createdTaskTime
			+ ", status=" + status + ", assigned to employee id: " + userInfo.getId() + "]";
}

}
