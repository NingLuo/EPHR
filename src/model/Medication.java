package model;

import java.util.Date;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Medication")
public class Medication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer medId;
	
	@Column(name="medName", nullable=false)
	private String medName;
	
	@Column(length=1024)
	private String instruction;
	
	@Temporal(TemporalType.DATE)
	private Date prescirbedDate;
	
	private Integer refills;
	private String pharmacy;
	private Integer quantity;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="patientId")
	@JsonIgnore
	private Patient patient;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="providerId")
	@JsonIgnore
	private Provider provider;
	

	public Medication() {
		super();
	}
	
	public Medication(Integer medId, String medName, String instruction, Date prescirbedDate, Integer refills,
			String pharmacy, Integer quantity, Patient patient, Provider provider) {
		super();
		this.medId = medId;
		this.medName = medName;
		this.instruction = instruction;
		this.prescirbedDate = prescirbedDate;
		this.refills = refills;
		this.pharmacy = pharmacy;
		this.quantity = quantity;
		this.patient = patient;
		this.provider = provider;
	}



	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Date getPrescirbedDate() {
		return prescirbedDate;
	}

	public void setPrescirbedDate(Date prescirbedDate) {
		this.prescirbedDate = prescirbedDate;
	}

	public Integer getRefills() {
		return refills;
	}

	public void setRefills(Integer refills) {
		this.refills = refills;
	}

	public String getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	
	
}
