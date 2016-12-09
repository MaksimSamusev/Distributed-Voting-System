package by.center.data.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.annotations.GenericGenerator;

import java.util.Comparator;

import javax.persistence.*;

@Entity
@Table(name = "STATISTIC")
public class Statistic {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id", length = 6, nullable = false)
	private long id;

	@Column(name = "candidate")
	private String candidate;

	@Column(name = "sector")
	private String sector;

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Column(name = "countVote")
	private Long countVote;
	
	
	public Statistic(String candidate, String sector, long countVote) {
		this.candidate = candidate;
		this.sector = sector;
		this.countVote=countVote;
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
	

	public Long getCountVote() {
		return countVote;
	}

	public void setCountVote(Long countVote) {
		this.countVote = countVote;
	}
	
	 public static final Comparator<Statistic> COMPARE_BY_COUNT = new Comparator<Statistic>() {
	        @Override
	        public int compare(Statistic lhs, Statistic rhs) {
	            return (int) (rhs.getCountVote() - lhs.getCountVote());
	        }
	    };
}