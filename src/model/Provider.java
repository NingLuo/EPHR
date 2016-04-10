package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Provider")
public class Provider extends User {
	@Column(nullable=false)
	private String name;
	
//	@Column(name="providerId", unique=true, nullable=false)
//	private String providerId;
	
	@Column(name="specialty", nullable=false)
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToMany(mappedBy="provider")
	private List<Connection> connections;
	
	@OneToMany(mappedBy="provider")
	@JsonIgnore
	private List<Medication> medications;

	public Provider(String name, Specialty specialty, Gender gender, List<Connection> connections,
			List<Medication> medications) {
		super();
		this.name = name;
//		this.providerId = providerId;
		this.specialty = specialty;
		this.gender = gender;
		this.connections = connections;
		this.medications = medications;
	}

	public Provider() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getProviderId() {
//		return providerId;
//	}
//
//	public void setProviderId(String providerId) {
//		this.providerId = providerId;
//	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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
