package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(ConnectionPK.class)
@Table(name="Connection")
public class Connection {
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="providerId")
	private Provider provider;
	
	@Temporal(TemporalType.DATE)
	@Column(name="start_time")
	private Date startTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_time")
	private Date endTime;

	public Connection() {
		super();
	}

	public Connection(Patient patient, Provider provider, Date startTime, Date endTime) {
		super();
		this.patient = patient;
		this.provider = provider;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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
	
	
}
