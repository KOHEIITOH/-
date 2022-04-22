package la.bean;

import java.io.Serializable;

public class ReserveBean implements Serializable{

	private int hotel_reserve_id;
	private int hotel_id;
	private String checkin_date;
	private String checkout_date;
	private int user_id;

	public int getHotel_reserve_id() {
		return hotel_reserve_id;
	}

	public void setHotel_reserve_id(int hotel_reserve_id) {
		this.hotel_reserve_id = hotel_reserve_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(String checkin_date) {
		this.checkin_date = checkin_date;
	}

	public String getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public ReserveBean() {
	}


	public ReserveBean(int hotel_reserve_id, int hotel_id, String checkin_date, String checkout_date,int user_id) {
		this.hotel_reserve_id = hotel_reserve_id;
		this.hotel_id = hotel_id;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.user_id = user_id;

	}


}
