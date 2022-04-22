package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.UserBean;




public class UserLoginDAO {
	public Connection con;
	PreparedStatement st;
	ResultSet rs;

	public UserLoginDAO() throws DAOException {
		getConnection();
	}
	 //ここから---------------------------------------------------------------


	//表示機能
	public List<UserBean> findAll() throws DAOException{
		if(con ==null)getConnection();



		try {

			String sql = "SELECT * FROM user_info";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<UserBean> list =new ArrayList<UserBean>();
			while (rs.next()) {

				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String user_address = rs.getString("user_address");
				String user_tel = rs.getString("user_tel");
				String user_email = rs.getString("user_email");
				String birthday = rs.getString("birtday");
				String membership_date = rs.getString("membership_date");
				String withdrawal_date = rs.getString("withdrawal_date");
				int user_password = rs.getInt("user_password");

				UserBean bean = new UserBean(user_id, user_name, user_address, user_tel, user_email, birthday, membership_date, withdrawal_date, user_password);

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
	//login機能
	public int login(String user_id, String user_password)throws DAOException {

		 getConnection();
		 try{
			 String sql = "select user_password from user_info where user_id = ?";

			 st = con.prepareStatement(sql);
			 st.setString(1, user_id);
			 rs = st.executeQuery();
			 if(rs.next()) {
				 if(rs.getString(1).equals(user_password)) {
					 return 1; //ログイン成功

				 }
				 else
				 {
					 return 0; 	//ID〇、パスワード✖
				 }
			 }
			 return -1; //ID✖
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
			 return -2; //データベースエラー
		 }



	//------------------------------------------------------------------------
			//登録機能
			public int InsertUser(int leuser_id, String leuser_name, String leuser_address, String leuser_tel, String leuser_email, String lebirthday, String lemembership_date,String lewithdrawal_date , int leuser_password)throws DAOException {
				if(con ==null)getConnection();
				PreparedStatement st = null;


			try {
				// SQL文の作成
				String sql = "INSERT INTO user_info(user_id, user_name, user_address, user_tel, user_email, birtday, membership_date, withdrawal_date, user_password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
				st = con.prepareStatement(sql);

				st.setInt(1, leuser_id);
				st.setString(2, leuser_name);
				st.setString(3, leuser_address);
				st.setString(4, leuser_tel);
				st.setString(5, leuser_email);
				st.setString(6, lebirthday);
				st.setString(7, lemembership_date);
				st.setString(8, lewithdrawal_date);
				st.setInt(9, leuser_password);

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


	 //ここまで---------------------------------------------------------------
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