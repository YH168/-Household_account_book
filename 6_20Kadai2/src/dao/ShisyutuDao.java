package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Shisyutu;
public class ShisyutuDao {

	//引数のIDに一致するレコードをemployeeテーブルから1件取得する。
	public static ArrayList<Shisyutu> shisyutu(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shisyutu> result = new ArrayList<Shisyutu>();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kakeibo?useSSL=false",
					"root",
					"0872");

			String sql = "SELECT * FROM shisyutu;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int kin = rs.getInt("kin");
				int year = rs.getInt("year");
				int mon = rs.getInt("mon");
				int day = rs.getInt("day");
				result.add(new Shisyutu(id, name , kin, year, mon, day));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {

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
