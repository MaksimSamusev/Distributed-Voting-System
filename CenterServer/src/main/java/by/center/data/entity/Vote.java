package by.center.data.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "VOTE")
public class Vote {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", length = 6, nullable = false)
	private long id;

	@Column(name = "candidate")
	private String candidate;

	@Column(name = "sector")
	private int sector;

	@JsonCreator
	public Vote() {
	}

	public Vote(String candidate, int sector) {
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

	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
	}
}