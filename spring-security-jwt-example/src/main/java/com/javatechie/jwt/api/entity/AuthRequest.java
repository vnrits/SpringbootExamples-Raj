package com.javatechie.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Generated;
import lombok.Getter;


import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthRequest {

    private String userName;
    private String password;
    
    
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
    
    
}
