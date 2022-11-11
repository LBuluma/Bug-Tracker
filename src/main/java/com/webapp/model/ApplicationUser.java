package com.webapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tracker.app_user")


//Class to represent the user who is going to login into the system
public class ApplicationUser implements Serializable{

	
	@Id
	@Column(name = "app_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

	
	@Column(name = "user_name")
    private String username;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private String password;

	@Column(name = "role_id ")
    private int roleId;
    
    @Column(name = "locked")
    private String locked;
    
    @Column(name = "enabled")
    private String enabled;
    
    @Column(name = "updated_by")
    private int updatedBy;
    
    @Column(name = "updated_date")
    private Date updatedDate;
    
    
    @Column(name = "created_by")
    private int createdBy;
    
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "user_id")
    private int userId;

	private static final long serialVersionUID = 1L;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date currentDate) {
		this.createdDate = currentDate;
	}

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	
	
  		

	

}
