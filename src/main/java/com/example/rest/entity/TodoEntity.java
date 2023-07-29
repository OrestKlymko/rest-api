package com.example.rest.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todo")
public class TodoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "completed")
	private Boolean completed;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
}
