package bean;

import java.io.Serializable;

public class AdminBean implements Serializable{
	private int user_id;
	private String user_name;
	private String user_address;
	private String user_tel;
	private String user_email;
	private String birthday;
	private String membership_date;
	private String withdrawal_date;
	private int user_password;

	public AdminBean(int user_id, String user_name, String user_address,
			String user_tel, String user_email, String birthday, String membership_date, String withdrawal_date,int user_password) {
		this.setUser_id(user_id);
		this.setUser_name(user_name);
		this.setUser_address(user_address);
		this.setUser_tel(user_tel);
		this.setUser_email(user_email);
		this.setBirthday(birthday);
		this.setMembership_date(membership_date);
		this.setWithdrawal_date(withdrawal_date);
		this.setUser_passwrod(user_password);
	}
	public AdminBean() {
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMembership_date() {
		return membership_date;
	}
	public void setMembership_date(String membership_date) {
		this.membership_date = membership_date;
	}
	public String getWithdrawal_date() {
		return withdrawal_date;
	}
	public void setWithdrawal_date(String withdrawal_date) {
		this.withdrawal_date = withdrawal_date;
	}
	public int getUser_password() {
		return user_password;
	}
	public void setUser_passwrod(int user_password) {
		this.user_password = user_password;
	}

}
