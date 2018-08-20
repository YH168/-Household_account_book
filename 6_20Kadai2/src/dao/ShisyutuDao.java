package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Itiran;

public class ItiranDao {

	//引数のIDに一致するレコードをemployeeテーブルから1件取得する。
	public static Itiran searchDao(int key){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Itiran result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/gamedb?useSSL=false",
					"root",
					"0872");
			// ④SQL文を作成する
			String sql = "SELECT * FROM mygame;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			// ⑦実行結果を含んだインスタンスからデータを取り出す
			/*rs.next();
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String sya = rs.getString("sya");
			String hard = rs.getString("hard");
			String jan = rs.getString("jan");
			int price = rs.getInt("price");
			result = new Itiran(id, name , sya, hard, jan, price);*/

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return result;
	}
}
