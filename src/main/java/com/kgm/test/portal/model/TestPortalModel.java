package com.kgm.test.portal.model;

import java.sql.Date;

public class TestPortalModel {

	private int userDetailsId;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNo;
	private String counsellorName;
	private String aboutInstitute;
	private String nativeCity;
	private String residenceCity;
	private String degree;
	private String employeeStatus;
	private Date updatedDate;
	
	
	private int studentsProgressDetailsId;
	private int numericBasic;
	private int numericIntermediate;
	private int numericAdvanced;
	private int verbalBasic;
	private int verbalIntermediate;
	private int verbalAdvanced;
	private int communication;
	private int updatedBy;

	public int getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCounsellorName() {
		return counsellorName;
	}

	public void setCounsellorName(String counsellorName) {
		this.counsellorName = counsellorName;
	}

	public String getAboutInstitute() {
		return aboutInstitute;
	}

	public void setAboutInstitute(String aboutInstitute) {
		this.aboutInstitute = aboutInstitute;
	}

	public String getNativeCity() {
		return nativeCity;
	}

	public void setNativeCity(String nativeCity) {
		this.nativeCity = nativeCity;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date date) {
		this.updatedDate = date;
	}

		public int getStudentsProgressDetailsId() {
		return studentsProgressDetailsId;
	}

	public void setStudentsProgressDetailsId(int studentsProgressDetailsId) {
		this.studentsProgressDetailsId = studentsProgressDetailsId;
	}

	public int getNumericBasic() {
		return numericBasic;
	}

	public void setNumericBasic(int numericBasic) {
		this.numericBasic = numericBasic;
	}

	public int getNumericIntermediate() {
		return numericIntermediate;
	}

	public void setNumericIntermediate(int numericIntermediate) {
		this.numericIntermediate = numericIntermediate;
	}

	public int getNumericAdvanced() {
		return numericAdvanced;
	}

	public void setNumericAdvanced(int numericAdvanced) {
		this.numericAdvanced = numericAdvanced;
	}

	public int getVerbalBasic() {
		return verbalBasic;
	}

	public void setVerbalBasic(int verbalBasic) {
		this.verbalBasic = verbalBasic;
	}

	public int getVerbalIntermediate() {
		return verbalIntermediate;
	}

	public void setVerbalIntermediate(int verbalIntermediate) {
		this.verbalIntermediate = verbalIntermediate;
	}

	public int getVerbalAdvanced() {
		return verbalAdvanced;
	}

	public void setVerbalAdvanced(int verbalAdvanced) {
		this.verbalAdvanced = verbalAdvanced;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

}
