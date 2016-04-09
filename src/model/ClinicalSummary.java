package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Clinical_Summary")
public class ClinicalSummary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date summaryDate;
	
	@Column(name="chief_complaint")
	private String chiefComplaint;
	private String bloodPressure;
	private String height;
	private String weight;
	private String pulse;
	private Integer bmi;
	private String instruction;
	private String referral;
	private String careTeam;
	
	@Temporal(TemporalType.DATE)
	private Date startTime;
	@Temporal(TemporalType.DATE)
	private Date endTime;
	
	private String tabaccoHistory;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patientId")
	@JsonIgnore     //Pay attention to THIS!!!!!!!!!!
	private Patient patient;
	
	public ClinicalSummary() {
		super();
	}

	public ClinicalSummary(Integer id, Date summaryDate, String chiefComplaint, String bloodPressure, String height,
			String weight, String pulse, Integer bmi, String instruction, String referral, String careTeam,
			Date startTime, Date endTime, String tabaccoHistory, Patient patient) {
		super();
		this.id = id;
		this.summaryDate = summaryDate;
		this.chiefComplaint = chiefComplaint;
		this.bloodPressure = bloodPressure;
		this.height = height;
		this.weight = weight;
		this.pulse = pulse;
		this.bmi = bmi;
		this.instruction = instruction;
		this.referral = referral;
		this.careTeam = careTeam;
		this.startTime = startTime;
		this.endTime = endTime;
		this.tabaccoHistory = tabaccoHistory;
		this.patient = patient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSummaryDate() {
		return summaryDate;
	}

	public void setSummaryDate(Date summaryDate) {
		this.summaryDate = summaryDate;
	}
	
	

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public Integer getBmi() {
		return bmi;
	}

	public void setBmi(Integer bmi) {
		this.bmi = bmi;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getReferral() {
		return referral;
	}

	public void setReferral(String referral) {
		this.referral = referral;
	}

	public String getCareTeam() {
		return careTeam;
	}

	public void setCareTeam(String careTeam) {
		this.careTeam = careTeam;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTabaccoHistory() {
		return tabaccoHistory;
	}

	public void setTabaccoHistory(String tabaccoHistory) {
		this.tabaccoHistory = tabaccoHistory;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
