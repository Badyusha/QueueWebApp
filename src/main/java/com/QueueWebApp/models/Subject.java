package com.QueueWebApp.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "subjectName", columnDefinition = "varchar(50)")
	private String subjectName;

	@Column(name = "subgroup", columnDefinition = "int")
	private Integer subgroup;

	@Column(name = "date")
	private LocalDate date;

	public Subject(String subjectName, Integer subgroup, LocalDate date) {
		this.subjectName = subjectName;
		this.subgroup = subgroup;
		this.date = date;
	}

	public Subject() { }

	@Override
	public boolean equals(Object object) {
		// If the object is compared with itself then return true
		if (object == this) {
			return true;
		}

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
		if (!(object instanceof Subject)) {
			return false;
		}

		// typecast o to Complex so that we can compare data members
		Subject subjectObject = (Subject) object;

		// Compare the data members and return accordingly
		return this.id.equals(subjectObject.id);
	}


	public Long getId() {
		return id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getSubgroup() {
		return subgroup;
	}

	public void setSubgroup(Integer subgroup) {
		this.subgroup = subgroup;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}