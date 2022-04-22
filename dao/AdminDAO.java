package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AdminBean;

public class AdminDAO{
	private Connection con;

	public AdminDAO() throws DAOException{
		getConnection();
	}

	//全会員表示
	public List<AdminBean> findAll() throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL
			String sql = "SELECT * FROM user_info ORDER BY user_id asc";
			//PreparedStatementのオブジェクトの取得
			st = con.prepareStatement(sql);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得および表示
			List<AdminBean> list = new ArrayList<AdminBean>();
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String user_address = rs.getString("user_address");
				String user_tel = rs.getString("user_tel");
				String user_email = rs.getString("user_email");
				String birthday = rs.getString("birthday");
				String membership_date = rs.getString("membership_date");
				String withdrawal_date = rs.getString("withdrawal_date");
				int user_password = rs.getInt("user_password");
				AdminBean bean = new AdminBean(user_id, user_name, user_address, user_tel, user_email,
						birthday, membership_date, withdrawal_date, user_password);
				list.add(bean);
			}
			//会員一覧をListとして返す
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
		finally {
			try {
				//リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}
			catch(Exception e) {
				throw new DAOException("リソースの取得に失敗しました。");
			}
		}

	}

	//検索
	public List<AdminBean> findById(int leuser_id) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL
			String sql = "SELECT * FROM user_info WHERE user_id = ?";
			//PreparedStatementのオブジェクトの取得
			st = con.prepareStatement(sql);
			//セット
			st.setInt(1, leuser_id);
			//SQLの実行
			rs = st.executeQuery();
			//結果の取得および表示
			List<AdminBean> list = new ArrayList<AdminBean>();
			while(rs.next()) {
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String user_address = rs.getString("user_address");
				String user_tel = rs.getString("user_tel");
				String user_email = rs.getString("user_email");
				String birthday = rs.getString("birthday");
				String membership_date = rs.getString("membership_date");
				String withdrawal_date = rs.getString("withdrawal_date");
				int user_password = rs.getInt("user_password");
				AdminBean bean = new AdminBean(user_id, user_name, user_address, user_tel, user_email, birthday, membership_date, withdrawal_date, user_password);
				list.add(bean);
			}

			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
		finally {
			try {
				//リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}
			catch(Exception e) {
				throw new DAOException("リソースの取得に失敗しました。");
			}
		}
	}

	//更新
	public int UpdateUser(int In_user_id, String In_user_name, String In_user_address,
			String In_user_tel, String In_user_email, String In_birthday, String In_membership_date,
			String In_withdrawal_date,int In_user_password) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;

		try {
			//SQL
			String sql = "UPDATE user_info SET user_name = ?, user_address = ?, "
					+ "user_tel = ?, user_email = ?, birthday = ?,  membership_date = ?,"
					+ " withdrawal_date = ?, user_password = ? WHERE user_id = ?";

			st = con.prepareStatement(sql);

			st = con.prepareStatement(sql);

			st.setInt(9, In_user_id);
			st.setString(1, In_user_name);
			st.setString(2, In_user_address);
			st.setString(3, In_user_tel);
			st.setString(4, In_user_email);
			st.setString(5, In_birthday);
			st.setString(6, In_membership_date);
			st.setString(7, In_withdrawal_date);
			st.setInt(8, In_user_password);

			//SQLの実行
			int rows = st.executeUpdate();
			return rows;

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
		finally {
			try {
				//リソースの開放
				if(st != null)st.close();
				close();
			}
			catch(Exception e) {
				throw new DAOException("リソースの取得に失敗しました。");
			}
		}
	}

	//削除
	public int deleteById(int user_id) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;

		try {
			//SQL
			String sql = "DELETE FROM user_info WHERE user_id = ?";

			st = con.prepareStatement(sql);
			st.setInt(1, user_id);

			//SQLの実行
			int rows = st.executeUpdate();
			return rows;

		}
		catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}
		finally {
			try {
				//リソースの開放
				if(st != null)st.close();
				close();
			}
			catch(Exception e) {
				throw new DAOException("リソースの取得に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException{
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL,ユーザー名、パスワード設定
			String url = "jdbc:postgresql:travel";
			String user = "postgres";
			String pass = "himitu";
			//データベースへの接続
			con = DriverManager.getConnection(url, user, pass);
		}
		catch(Exception e){
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}