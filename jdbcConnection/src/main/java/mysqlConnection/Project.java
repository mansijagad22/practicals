package mysqlConnection;

import java.sql.Date;

public class Project {
	private int projectId;
	private String projectName;	
	private String projectFeature;	
	private Date assignDate;
	private Date startDate;	
	private Date completeDate;
	
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
	public Date getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
}

