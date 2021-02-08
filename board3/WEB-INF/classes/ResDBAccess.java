import bean.PostBean;

import java.util.ArrayList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigDecimal;

public class ResDBAccess{

	private ArrayList<PostBean> replies = new ArrayList<PostBean>();
	
	public ArrayList<PostBean> allSelect(String sql){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("接続完了");
			
			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し//ResultSetインターフェイスを実装したクラスのインスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				PostBean bean = new PostBean();

				int threadID = rs.getInt(1);
				int resID=rs.getInt(2);	//二つ目の列
				String resContent=rs.getString(3);	
				
				bean.setThreadID(threadID);
				bean.setResID(resID);
				bean.setResContent(resContent);
				
				replies.add(bean);
			}
			
			//Oracleから切断する
			cn.close();
			System.out.println("切断完了");

		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("クラスがないみたい。");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL関連の例外みたい。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return replies;
	}
	public void insert(String sql){
		try{
			//Driverインターフェイスを実装するクラスをロードする
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connectionインターフェイスを実装するクラスの
			//インスタンスを返す
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			
			//自動コミットをOFFにする
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");
			
			//Statementインターフェイスを実装するクラスの
			//インスタンスを取得する
			Statement st=cn.createStatement();
			
			//SQLを実行しトランザクションが開始される。処理件数が返される
			int count=st.executeUpdate(sql);
			
			System.out.println(count+"件処理完了");
			
			//トランザクションをコミットする
			cn.commit();
			
			//ステートメントをクローズする
			st.close();
			
			//RDBMSから切断する
			cn.close();
			
			System.out.println("切断完了");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}