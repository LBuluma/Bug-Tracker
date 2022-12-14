package com.webapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracker.user_role")
public class UserRoles {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId ;
	
	@Column(name = "role_name")
	private String roleName;
	
	//Removed the project id relation
//	@Column(name = "project_id")
//	private int projectId;

	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "created_by")
	private int createdBy;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private Date updatedDate;
	
	@Column(name = "active_flag")
	private String activeFlag;
	
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	//Removed the project id relation
//	public int getProjectId() {
//		return projectId;
//	}
//
//	public void setProjectId(int projectId) {
//		this.projectId = projectId;
//	}

	public String getActiveFlag() {
		return activeFlag;
	}
	
	

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	

	
	
	

}
