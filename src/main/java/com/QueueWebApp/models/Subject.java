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

	@Column(name = "subgroup", columnDefinition = "varchar(5)")
	private String subgroup;

	@Column(name = "date")
	private LocalDate date;

	public Subject(String subjectName, String subgroup, LocalDate date) {
		this.subjectName = subjectName;
		this.subgroup = subgroup;
		this.date = date;
	}

	public Subject() {
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

	public String getSubgroup() {
		return subgroup;
	}

	public void setSubgroup(String subgroup) {
		this.subgroup = subgroup;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}