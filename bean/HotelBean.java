package bean;

import java.io.Serializable;

public class HotelBean implements Serializable{
	private int hotel_id;
	private String hotel_name;
	private int hotel_price;
	private String hotel_img;
	private String hotel_info;
	private String hotel_address;
	private String hotel_tel;
	private String hotel_email;

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public int getHotel_price() {
		return hotel_price;
	}

	public void setHotel_price(int hotel_price) {
		this.hotel_price = hotel_price;
	}

	public String getHotel_img() {
		return hotel_img;
	}

	public void setHotel_img(String hotel_img) {
		this.hotel_img = hotel_img;
	}

	public String getHotel_info() {
		return hotel_info;
	}

	public void setHotel_info(String hotel_info) {
		this.hotel_info = hotel_info;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public String getHotel_tel() {
		return hotel_tel;
	}

	public void setHotel_tel(String hotel_tel) {
		this.hotel_tel = hotel_tel;
	}

	public String getHotel_email() {
		return hotel_email;
	}

	public void setHotel_email(String hotel_email) {
		this.hotel_email = hotel_email;
	}

	public HotelBean() {
	}

	public HotelBean(int hotel_id, String hotel_name, int hotel_price, String hotel_img, String hotel_info, String hotel_address, String hotel_tel, String hotel_email) {
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_price = hotel_price;
		this.hotel_img = hotel_img;
		this.hotel_info = hotel_info;
		this.hotel_address = hotel_address;
		this.hotel_tel = hotel_tel;
		this.hotel_email = hotel_email;

	}


}
