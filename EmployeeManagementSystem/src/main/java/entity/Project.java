package entity;

import java.sql.Date;

public class Project {
	private int projectId;
	private String projectName;	
	private String projectFeature;	
	private String status;
	
	public Project(int projectId2, String name, String feature,String status) {
		this.projectId = projectId2;
		this.projectName = name;
		this.projectFeature = feature;
		this.status = status;
		
		// TODO Auto-generated constructor stub
	}
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectFeature() {
		return projectFeature;
	}
	public void setProjectFeature(String projectFeature) {
		this.projectFeature = projectFeature;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

