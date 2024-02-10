package com.QueueWebApp.models;

import jakarta.persistence.*;


@Entity
@Table(name = "queues")
public class Queue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "subjectId", nullable = false)
	private Subject subject;

	public Queue() {
	}

	public Queue(User user, Subject subject) {
		this.user = user;
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}