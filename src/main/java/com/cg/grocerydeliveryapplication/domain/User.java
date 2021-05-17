package com.cg.grocerydeliveryapplication.domain;

import javax.persistence.*;


@Entity
@Table(name = "Registration")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid")
    private Integer uId;
    @Column(name = "f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
	@Column(name = "email")
    private String email;
    public User(Integer uId, String fName, String lName, String userName, String password, String email,
			long phone, String address) {
		super();
		this.uId = uId;
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	@Column(name = "phone")
    private long phone;
    @Column(name = "address")
    private String address;
    
    @Override
   	public String toString() {
   		return "User [uId=" + uId + ", fName=" + fName + ", lName=" + lName + ", userName=" + userName + ", password="
   				+ password + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
   	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		
	}
	
    	
}
