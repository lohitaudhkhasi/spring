package com.spring.project;

import java.util.Date;

public class Project {
	private String projectName;
	private Integer projectId;
	
	private Date startDate;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectId=" + projectId + ", startDate=" + startDate + "]";
	}
}
