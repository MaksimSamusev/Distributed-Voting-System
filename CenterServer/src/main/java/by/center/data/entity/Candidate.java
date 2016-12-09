package by.center.data.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "CANDIDATE")
public class Candidate {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", length = 6, nullable = false)
	private long id;

	@Column(name = "candidate")
	private String candidate;

	@Column(name = "sector")
	private String sector;	
	
	@JsonCreator
	public Candidate() {
	}

	public Candidate(String candidate, String sector) {
		this.candidate = candidate;
		this.sector = sector;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
}