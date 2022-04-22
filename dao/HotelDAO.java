package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.HotelBean;


public class HotelDAO {
	private Connection con;


	public HotelDAO() throws DAOException {
		getConnection();
	}
//------------------------------------------------------------------------
	//表示機能
	public List<HotelBean> findAll() throws DAOException{
		if(con ==null)getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM hotel_info ORDER BY hotel_id asc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<HotelBean> list =new ArrayList<HotelBean>();
			while (rs.next()) {

				int hotel_id = rs.getInt("hotel_id");
				String hotel_name = rs.getString("hotel_name");
				int hotel_price = rs.getInt("hotel_price");
				String hotel_img = rs.getString("hotel_img");
				String hotel_info = rs.getString("hotel_info");
				String hotel_address = rs.getString("hotel_address");
				String hotel_tel = rs.getString("hotel_tel");
				String hotel_email = rs.getString("hotel_email");

				HotelBean bean = new HotelBean(hotel_id, hotel_name, hotel_price, hotel_img, hotel_info, hotel_address, hotel_tel, hotel_email);

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
	public List<HotelBean> SearchHotel(int leHotel_id) throws DAOException{
	if(con ==null)getConnection();

	PreparedStatement st = null;
	ResultSet rs = null;

	try {
		// SQL文の作成
		String sql = "SELECT * FROM hotel_info WHERE Hotel_id = ?";
		st = con.prepareStatement(sql);
		st.setInt(1, leHotel_id);

		rs = st.executeQuery();
		List<HotelBean> list =new ArrayList<HotelBean>();
		while (rs.next()) {

			int hotel_id = rs.getInt("hotel_id");
			String hotel_name = rs.getString("hotel_name");
			int hotel_price = rs.getInt("hotel_price");
			String hotel_img = rs.getString("hotel_img");
			String hotel_info = rs.getString("hotel_info");
			String hotel_address = rs.getString("hotel_address");
			String hotel_tel = rs.getString("hotel_tel");
			String hotel_email = rs.getString("hotel_email");

			HotelBean bean = new HotelBean(hotel_id, hotel_name, hotel_price, hotel_img, hotel_info, hotel_address, hotel_tel, hotel_email);

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
		public int DeleteHotel(int Hotel_id) throws DAOException{
		if(con ==null)getConnection();
		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "DELETE FROM hotel_info WHERE Hotel_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, Hotel_id);
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
		public int InsertHotel(int In_hotel_id, String In_hotel_name, int In_hotel_price, String In_hotel_img, String In_hotel_info, String In_hotel_address, String In_hotel_tel, String In_hotel_email) throws DAOException{
		if(con ==null)getConnection();
		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "INSERT INTO hotel_info(hotel_id, hotel_name, hotel_price, hotel_img, hotel_info, hotel_address, hotel_tel, hotel_email) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, In_hotel_id);
			st.setString(2, In_hotel_name);
			st.setInt(3, In_hotel_price);
			st.setString(4, In_hotel_img);
			st.setString(5, In_hotel_info);
			st.setString(6, In_hotel_address);
			st.setString(7, In_hotel_tel);
			st.setString(8, In_hotel_email);

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

		public int UpdateHotel(int In_hotel_id, String In_hotel_name, int In_hotel_price, String In_hotel_img, String In_hotel_info, String In_hotel_address, String In_hotel_tel, String In_hotel_email) throws DAOException{
			if(con ==null)getConnection();
			PreparedStatement st = null;
			try {
				// SQL文の作成
				String sql = "UPDATE hotel_info SET hotel_name=?, hotel_price=?, hotel_img=?, hotel_info=?, hotel_address=?, hotel_tel=?, hotel_email=? WHERE hotel_id =?";
				// PreparedStatementオブジェクトの取得
				st = con.prepareStatement(sql);
				// 主キーの指定
			st = con.prepareStatement(sql);

			st.setInt(8, In_hotel_id);
			st.setString(1, In_hotel_name);
			st.setInt(2, In_hotel_price);
			st.setString(3, In_hotel_img);
			st.setString(4, In_hotel_info);
			st.setString(5, In_hotel_address);
			st.setString(6, In_hotel_tel);
			st.setString(7, In_hotel_email);

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