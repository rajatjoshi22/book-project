package com.bookapp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="springuser")
public class User {
@Id
@Column(name="loginid")
private String loginId;
@Column(name="password")
private String password;
@Column(name="username")
private String userName;
@Column(name="mobilenumber")
private Long   mobileNumber;

}
