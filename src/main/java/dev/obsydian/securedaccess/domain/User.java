package dev.obsydian.securedaccess.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Column(name = "first_name")
	@NotEmpty(message = "Please enter Your first name")
	@Size(max = 50)
	private String firstName;

	@Column(name = "second_name")
	@NotEmpty(message = "Please enter Your second name")
	@Size(max = 50)
	private String secondName;

	@Column(name = "email")
	@Email(message = "Please enter a valid email address")
	@NotEmpty(message = "Please type a correct email address")
	private String email;

	@Column(name = "password", columnDefinition="CHAR(68)")
	@NotEmpty(message = "Please enter")
	@Size(min = 4,message = "*password must have at least 4 characters")
	private String password;

	@Column(name = "enabled")
	@NotNull
	@ColumnDefault("true")
	private boolean enabled = true;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
