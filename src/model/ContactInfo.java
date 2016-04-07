package model;

import javax.persistence.*;

@Entity
@Table(name="Contact_Info")
public class ContactInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="patientId")
	private Patient patient;
	
	public ContactInfo() {
		super();
	}

	public ContactInfo(String phone, String email, Patient patient) {
		super();
		this.phone = phone;
		this.email = email;
		this.patient = patient;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
