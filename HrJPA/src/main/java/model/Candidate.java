package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@Table(name="candidate")
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCandidate;

	private String contactNumber;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String email;

	private String name;

	//bi-directional many-to-many association to Candidate
	
		@ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
		@JoinTable(
			name="candidateskills"
			, joinColumns={
				@JoinColumn(name="idCandidate")
				}
			, inverseJoinColumns={
				@JoinColumn(name="idSkill")
				}
			)
	private Set<Skill> skills;

	public Candidate() {
		skills = new HashSet<Skill>();
	}

	public int getIdCandidate() {
		return this.idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}


	
}