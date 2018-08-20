package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Touroku;

public class Touroku2Dao {

	//引数のIDに一致するレコードをemployeeテーブルから1件取得する。
	public static Touroku setDao(int id , String name, int kin, int year, int mon, int day){
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		Touroku result = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kakeibo?useSSL=false",
					"root",
					"0872");
			// ④SQL文を作成する
			String sql = "INSERT INTO shunyu VALUES(?,?,?,?,?,?);";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3,kin);
			pstmt.setInt(4,year);
			pstmt.setInt(5,mon);
			pstmt.setInt(6,day);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
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