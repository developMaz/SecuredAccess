package dev.obsydian.securedaccess.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.management.relation.RoleList;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
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


//	@Override
//	public String toString() {
//		return "User{" +
//				"id=" + id +
//				", firstName='" + firstName + '\'' +
//				", email='" + email + '\'' +
//				", password='" + password + '\'' +
//				", enabled=" + enabled +
//				", roles=" + roles +
//				'}';
//	}

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "user_id")
//	private int id;
//
//	@Column(name = "user_first_name")
//	@NotEmpty(message = "Please enter Your first name")
//	@Size(max = 50)
//	private String firstName;
//
//	@Column(name = "user_last_name")
//	@NotEmpty(message = "Please enter Your last name")
//	@Size(max = 50)
//	private String lastName;
//
//	@Column(name = "user_email")
//	@Email(message = "Please enter a valid email address")
//	@NotEmpty(message = "Please type a correct email address")
//	private String email;
//
//	@Column(name = "user_password", columnDefinition="CHAR(68)")
//	@NotEmpty(message = "Please enter")
//	@Size(min = 4,message = "*password must have at least 4 characters")
//	private String password;
//
//	@Column(name = "enabled")
//	@NotNull
//	private boolean enabled;
//
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles;
//
//	public User(String firstName, String lastName, String email, String password, boolean enabled) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.enabled = enabled;
//	}



}
