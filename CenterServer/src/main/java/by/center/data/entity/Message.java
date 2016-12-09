package by.center.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2888913245013140203L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", length = 6, nullable = false)
	private Long id;

	@Column
	private int sector;

	@Column
	private String candidate;

	@JsonCreator
	public Message() {
	}

	public Message(int sector, String candidate) {
		this.sector = sector;
		this.candidate = candidate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
}
