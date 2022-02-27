package com.hrm.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.nopCommerce.GlobalConstants;

public class EmployeeData {

	public static EmployeeData getEmployeeData() {

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(
					new File(GlobalConstants.PROJECT_PATH + "\\testdata\\com\\hrm\\data\\employee.json"),
					EmployeeData.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("fullname")
	private String fullname;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("adminusername")
	private String adminusername;
	@JsonProperty("adminpassword")
	private String adminpassword;
	@JsonProperty("statusdropdown")
	private String statusdropdown;
	@JsonProperty("email")
	private String email;

	public String getFirstname() {
		return firstname;
	}

	public String getEmail() {
		return email;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFullname() {
		return fullname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAdminusername() {
		return adminusername;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public String getStatusdropdown() {
		return statusdropdown;
	}

	@JsonProperty("ContactDetail")
	ContactDetail contactDetail;

	public static class ContactDetail {
		@JsonProperty("editFirstname")
		private String editFirstname;

		@JsonProperty("editLastname")
		private String editLastname;

		public String getEditFirstName() {
			return editFirstname;
		}

		public String getEditLastName() {
			return editLastname;
		}
	}

}
