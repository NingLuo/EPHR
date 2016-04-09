package model;

import java.util.Date;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Test_Result")
public class TestResult {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer resultId;
	
	@Temporal(TemporalType.DATE)
	private Date testDate;
	
	private String OrderedBy;
	
	@Enumerated(EnumType.STRING)
	private TestStatus testStatus;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patientId")
	@JsonIgnore 
	private Patient patient;
	
	public TestResult() {
		super();
	}

	public TestResult(Integer resultId, Date testDate, String orderedBy, TestStatus testStatus, Patient patient) {
		super();
		this.resultId = resultId;
		this.testDate = testDate;
		OrderedBy = orderedBy;
		this.testStatus = testStatus;
		this.patient = patient;
	}

	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public String getOrderedBy() {
		return OrderedBy;
	}

	public void setOrderedBy(String orderedBy) {
		OrderedBy = orderedBy;
	}

	public TestStatus getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(TestStatus testStatus) {
		this.testStatus = testStatus;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
