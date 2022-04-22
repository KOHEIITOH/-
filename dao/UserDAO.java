package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ReserveBean;
import la.bean.UserBean;


public class UserDAO {
	private Connection con;


	public UserDAO() throws DAOException {
		getConnection();
	}
//------------------------------------------------------------------------
	//表示機能：名前「findAllReserve」
	public List<ReserveBean> findAllReserve() throws DAOException{
		if(con ==null)getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM hotel_reserve";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<ReserveBean> list =new ArrayList<ReserveBean>();
			while (rs.next()) {

				int hotel_reserve_id = rs.getInt("hotel_reserve_id");
				int hotel_id = rs.getInt("hotel_id");
				String checkin_date = rs.getString("checkin_date");
				String checkout_date = rs.getString("checkout_date");
				int user_id = rs.getInt("user_id");

				ReserveBean bean = new ReserveBean(hotel_reserve_id,hotel_id,checkin_date,checkout_date,user_id);

				list.add(bean);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				close();
			}catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}



	//------------------------------------------------------------------------
	//リザーブ検索機能

	public List<ReserveBean> SerchReserve(int Reuser_id) throws DAOException{
	if(con ==null)getConnection();

	PreparedStatement st = null;
	ResultSet rs = null;

	try {
		// SQL文の作成
		String sql = "SELECT * FROM hotel_reserve WHERE user_id = ?";
		st = con.prepareStatement(sql);
		st.setInt(1, Reuser_id);
		rs = st.executeQuery();

		List<ReserveBean> list =new ArrayList<ReserveBean>();
		while (rs.next()) {

			int hotel_reserve_id = rs.getInt("hotel_reserve_id");
			int hotel_id = rs.getInt("hotel_id");
			String checkin_date = rs.getString("checkin_date");
			String checkout_date = rs.getString("checkout_date");
			int user_id = rs.getInt("user_id");

			ReserveBean bean = new ReserveBean(hotel_reserve_id,hotel_id,checkin_date,checkout_date,user_id);

			list.add(bean);
		}
		return list;


	}catch (Exception e) {
		e.printStackTrace();
		throw new DAOException("レコードの取得に失敗しました。");
	}finally {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			close();
		}catch (Exception e) {
			throw new DAOException("リソースの開放に失敗しました。");
		}
	}
}


	//------------------------------------------------------------------------
	//検索機能

	public List<UserBean> SearchUser(int Reuser_id) throws DAOException{
	if(con ==null)getConnection();

	PreparedStatement st = null;
	ResultSet rs = null;

	try {
		// SQL文の作成
		String sql = "SELECT * FROM user_info WHERE user_id = ?";
		st = con.prepareStatement(sql);
		st.setInt(1, Reuser_id);

		rs = st.executeQuery();
		List<UserBean> list =new ArrayList<UserBean>();
		while (rs.next()) {

			int user_id = rs.getInt("user_id");
			String user_name = rs.getString("user_name");
			String user_address = rs.getString("user_address");
			String user_tel = rs.getString("user_tel");
			String user_email = rs.getString("user_email");
			String birtday = rs.getString("birtday");
			String membership_date = rs.getString("membership_date");
			String withdrawal_date = rs.getString("withdrawal_date");
			int user_password = rs.getInt("user_password");

			UserBean bean = new UserBean(user_id, user_name, user_address, user_tel, user_email, birtday, membership_date, withdrawal_date, user_password);

			list.add(bean);
		}
		return list;
	}catch (Exception e) {
		e.printStackTrace();
		throw new DAOException("レコードの取得に失敗しました。");
	}finally {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			close();
		}catch (Exception e) {
			throw new DAOException("リソースの開放に失敗しました。");
		}
	}
}


	//------------------------------------------------------------------------
		//削除機能
		public int DeleteUser(int User_id) throws DAOException{
		if(con ==null)getConnection();
		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "DELETE FROM user_info WHERE user_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, User_id);
			//SQLの実行
				int rows = st.executeUpdate();
			return rows;

		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				if(st != null) st.close();
				close();
			}catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}



		//------------------------------------------------------------------------
		//登録機能
		public int reserve_travel(int Rn_hotel_reserve_id,int Rn_hotel_id, String Rn_checkin_date, String Rn_checkout_date, int Rn_user_id) throws DAOException{
		if(con ==null)getConnection();
		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "INSERT INTO hotel_reserve(hotel_reserve_id, hotel_id, checkin_date, checkout_date, user_id) VALUES(?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, Rn_hotel_reserve_id);
			st.setInt(2, Rn_hotel_id);
			st.setString(3, Rn_checkin_date);
			st.setString(4, Rn_checkout_date);
			st.setInt(5, Rn_user_id);

			//SQLの実行
				int rows = st.executeUpdate();
			return rows;

		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				if(st != null) st.close();
				close();
			}catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}


		//------------------------------------------------------------------------
		//変更機能

		public int UpdateUser(int Inuser_id, String Inuser_name, String Inuser_address,String Inuser_tel,String Inuser_email,String Inbirtday,String Inmembership_date,String Inwithdrawal_date,int Inuser_password) throws DAOException{
			if(con ==null)getConnection();
			PreparedStatement st = null;
			try {
				// SQL文の作成
				String sql = "UPDATE user_info SET user_name=?, user_address=?, user_tel=?, user_email=?, birtday=?, membership_date=? ,withdrawal_date=? ,user_password=? WHERE user_id =?";
				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// 主キーの指定
			st = con.prepareStatement(sql);

			st.setInt(9, Inuser_id);
			st.setString(1, Inuser_name);
			st.setString(2, Inuser_address);
			st.setString(3, Inuser_tel);
			st.setString(4, Inuser_email);
			st.setString(5, Inbirtday);
			st.setString(6, Inmembership_date);
			st.setString(7, Inwithdrawal_date);
			st.setInt(8, Inuser_password);

			//SQLの実行
				int rows = st.executeUpdate();
			return rows;

		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				if(st != null) st.close();
				close();
			}catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}



	 //データベース接続---------------------------------------------------------------
	private void getConnection() throws DAOException{
		try {
			//JDBC ドライバの登録
			Class.forName("org.postgresql.Driver");
			//データベースの接続先
			String url = "jdbc:postgresql:travel";
			//接続するユーザー名
			String user = "postgres";
			//データベースパスワード
			String pass = "himitu";
			//データベースの接続
			con = DriverManager.getConnection(url, user, pass);
		}catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}
	private void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;

		}
	}
}