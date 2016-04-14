package model;

import java.io.Serializable;
import javax.persistence.Entity;

public class ConnectionPK implements Serializable{
	private Integer patient;
	private Integer provider;
}
