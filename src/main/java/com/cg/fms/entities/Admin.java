package com.cg.fms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "admin_tbl")

public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	
	@Column(name = "name")
	@NotNull
	@Size(min = 2, message = "Name should have mininum 2 characters!!")
	private String name;
	
	
	@Column(name = "email")
	@Email(message = "Enter a valid email address!!")
	private String email;
	

	@NotNull
	@Size(min = 7, message = "Password should have mininum 7 characters!!")
	public String password;


}