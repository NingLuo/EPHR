package model;

import javax.persistence.*;

@Entity
@Table(name="Blood_Test")
public class BloodTest extends TestResult {
	private String acidity;
	private String alcohol;
	private String ammonia;
	private String amylase;
	private String bloodVolume;
	private String calcium;
	private String co2pressure;
	private String copper;
	private String glucose;
	
	public BloodTest() {
		super();
	}

	public BloodTest(String acidity, String alcohol, String ammonia, String amylase, String bloodVolume, String calcium,
			String co2pressure, String copper, String glucose) {
		super();
		this.acidity = acidity;
		this.alcohol = alcohol;
		this.ammonia = ammonia;
		this.amylase = amylase;
		this.bloodVolume = bloodVolume;
		this.calcium = calcium;
		this.co2pressure = co2pressure;
		this.copper = copper;
		this.glucose = glucose;
	}
	
	public String getAcidity() {
		return acidity;
	}
	public void setAcidity(String acidity) {
		this.acidity = acidity;
	}
	public String getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	public String getAmmonia() {
		return ammonia;
	}
	public void setAmmonia(String ammonia) {
		this.ammonia = ammonia;
	}
	public String getAmylase() {
		return amylase;
	}
	public void setAmylase(String amylase) {
		this.amylase = amylase;
	}
	public String getBloodVolume() {
		return bloodVolume;
	}
	public void setBloodVolume(String bloodVolume) {
		this.bloodVolume = bloodVolume;
	}
	public String getCalcium() {
		return calcium;
	}
	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}
	public String getCo2pressure() {
		return co2pressure;
	}
	public void setCo2pressure(String co2pressure) {
		this.co2pressure = co2pressure;
	}
	public String getCopper() {
		return copper;
	}
	public void setCopper(String copper) {
		this.copper = copper;
	}
	public String getGlucose() {
		return glucose;
	}
	public void setGlucose(String glucose) {
		this.glucose = glucose;
	}
	
}
