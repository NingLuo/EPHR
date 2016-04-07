package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Patient")
public class Patient extends User{
	
//	@Column(name="patientId", nullable=false, unique=true)
//	private String patientId;
	
	@Column(name="patient_name", nullable=false)
	private String patientName;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private String healthPlan;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private String ethnicity;
	
	private String language;
	
	private String address;
	
	@OneToMany(mappedBy="patient")
	private List<ClinicalSummary> clinicalSummaries;
	
	@OneToMany(mappedBy="patient")
	private List<ContactInfo> contactInfoList;
	
	@OneToMany(mappedBy="patient")
	private List<TestResult> testResults;
	
	@OneToMany(mappedBy="patient")
	private List<Connection> connections;
	
	@OneToMany(mappedBy="patient")
	private List<Medication> medications;
	
	public Patient() {
		super();
	}

	public Patient(String patientName, Date dob, String healthPlan, Gender gender, String ethnicity,
			String language, String address, List<ClinicalSummary> clinicalSummaries, List<ContactInfo> contactInfoList,
			List<TestResult> testResults, List<Connection> connections, List<Medication> medications) {
		super();
//		this.patientId = patientId;
		this.patientName = patientName;
		this.dob = dob;
		this.healthPlan = healthPlan;
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.language = language;
		this.address = address;
		this.clinicalSummaries = clinicalSummaries;
		this.contactInfoList = contactInfoList;
		this.testResults = testResults;
		this.connections = connections;
		this.medications = medications;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
//	public String getPatientId() {
//		return patientId;
//	}
//
//	public void setPatientId(String patientId) {
//		this.patientId = patientId;
//	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getHealthPlan() {
		return healthPlan;
	}
	public void setHealthPlan(String healthPlan) {
		this.healthPlan = healthPlan;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public List<ClinicalSummary> getClinicalSummaries() {
		return clinicalSummaries;
	}

	public void setClinicalSummaries(List<ClinicalSummary> clinicalSummaries) {
		this.clinicalSummaries = clinicalSummaries;
	}

	public List<ContactInfo> getContactInfoList() {
		return contactInfoList;
	}

	public void setContactInfoList(List<ContactInfo> contactInfoList) {
		this.contactInfoList = contactInfoList;
	}

	public List<TestResult> getTestResults() {
		return testResults;
	}

	public void setTestResults(List<TestResult> testResults) {
		this.testResults = testResults;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}
}
