package org.zegock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//db에 데이터입력하기
@Controller
@RequestMapping("ex25")
public class Controller25 {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("sub01")
	public void m1()throws Exception{
		// mydb1.t71 에 레코드 입력
		// 어느 db사용할지는 jdbc.properties파일에서변경 (root-context파일과 설정 매치해야함) 
		String sql="insert into t71(col1,col2) "
				+ "values(?, ?)";
		
		try(Connection con = dataSource.getConnection();
				PreparedStatement preparedStatement = con.prepareStatement(sql)){
			preparedStatement.setInt(1, 99999);
			preparedStatement.setDouble(2, 2983.33);
					
					int cnt = preparedStatement.executeUpdate();
					System.out.println(cnt+"개 레코드 입력 성공.");
				}
	}
		@RequestMapping("sub02")
		public void method02() throws SQLException {
			String sql="insert into t71(col1,col2) "
					+ "values(?, ?)";
			
			try(Connection con = dataSource.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
						pstmt.setInt(1, 99999);
						pstmt.setDouble(2, 2983.33);
						
						int cnt=pstmt.executeUpdate();
						System.out.println(cnt+"개 레코드 입력 성공.");
					}
	}
		@RequestMapping("sub03")
		public void method3() throws Exception {
			String sql = "SELECT col1, col2, col3, col4, col5, col6 "
					+ "FROM myTable07";
			
			try (Connection con = dataSource.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);) {
				
				while (rs.next()) { // 데이터 타입은 엄격하게 지키지 않아도 됨. 자동형변환되는 경우가 많다고 함.
					int col1 = rs.getInt("col1");
					double col2 = rs.getDouble("col2");
					String col3 = rs.getString("col3");
					String col4 = rs.getString("col4");
					java.sql.Date col5 = rs.getDate("col5");
					java.sql.Timestamp col6 = rs.getTimestamp("col6");
					
					System.out.println(col1);
					System.out.println(col2);
					System.out.println(col3);
					System.out.println(col4);
					System.out.println(col5);
					System.out.println(col6);
					System.out.println();
				}
			}
		}
		@RequestMapping("sub04")
		public void method4() throws Exception {
			String sql = "SELECT col1, col2  " //스페이스 쓰는거 꼭 하기..
					+ "FROM t71";
			
			try (Connection con = dataSource.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);) {
				
				while (rs.next()) { // 데이터 타입은 엄격하게 지키지 않아도 됨. 자동형변환되는 경우가 많다고 함.
					int col1 = rs.getInt("col1");
					double col2 = rs.getDouble("col2");
//					String col3 = rs.getString("col3");
//					String col4 = rs.getString("col4");
//					java.sql.Date col5 = rs.getDate("col5");
//					java.sql.Timestamp col6 = rs.getTimestamp("col6");
					
					System.out.println(col1);
					System.out.println(col2);
// 1,2,3형
// -- 어떤 테이블이 다른 테으블의 프라이머리키를(?) 컬럼으로 가지고 있을 때 그 키를 forien key(여러개 가능)라고 함. 두 테이블의 연결성.  
//			        -- 정규화 때문에 테이블이 나눠지게되는데, 포린키를 이용해서 여러 테이블을 연결해줌.
//			         --   ? 종속된 컬럼이 없도록 하라고? 
					

//  SELECT * FROM (SELECT CategoryID, AVG(Price) average FROM Products GROUP BY CategoryID) A WHERE average > 30;
					// A가 뭐지??  >> 그냥 아무 문자나 써도 됨. 그냥 변수인가봐...
				}
			}
		}
}

