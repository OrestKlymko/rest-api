package com.example.rest.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<TodoEntity> todoList;
}
