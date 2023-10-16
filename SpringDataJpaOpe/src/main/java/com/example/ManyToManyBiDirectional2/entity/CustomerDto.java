package com.example.ManyToManyBiDirectional2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerDto {

	@Id
	private Integer customerId;
	
	private String customreName;
	
	private Character gender;
	
	private String email;
	

	private Long phoneNumber;
	
	private String address;

	public CustomerDto(Integer customerId, String customreName, Character gender, String email, Long phoneNumber,
			String address) {
		super();
		this.customerId = customerId;
		this.customreName = customreName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customreName;
	}

	public void setCustomerName(String customreName) {
		this.customreName = customreName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customreName=" + customreName + ", gender=" + gender
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	
	public static Customer prepareCustomer(CustomerDto
			 customerDto)
	{
		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setEmail(customerDto.getEmail());
		customer.setGender(customerDto.getGender());
		customer.setAddress(customerDto.getAddress());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		return customer;
	}
	
}
