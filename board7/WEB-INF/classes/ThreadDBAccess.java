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

public class ThreadDBAccess{

	private ArrayList<PostBean> threads = new ArrayList<PostBean>();
    private ArrayList<PostBean> thread = new ArrayList<PostBean>();
	
    public ArrayList<PostBean> singleSelect(String sql){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","seikai","seikaipass");
			System.out.println("接続完了");
			
			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st = cn.createStatement();

			//select文を実行し//ResultSetインターフェイスを実装したクラスのインスタンスが返る
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
			int threadID = rs.getInt(1);
			String title = rs.getString(2);	//ふたつめの列
			String threadCreateName = rs.getString(3);
			String content = rs.getString(4);
			String date = rs.getString(5);
			String genre = rs.getString(6);
			
			PostBean bean = new PostBean();
			bean.setThreadID(threadID);
			bean.setTitle(title);
			bean.setThreadCreateName(threadCreateName);
			bean.setContent(content);
			bean.setDate(date);
			bean.setGenre(genre);
			
			thread.add(bean);
			
			
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
		return thread;
	}

	public ArrayList<PostBean> allSelect(String sql){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","seikai","seikaipass");
			System.out.println("接続完了");
			
			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し//ResultSetインターフェイスを実装したクラスのインスタンスが返る
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				PostBean bean = new PostBean();

				int threadID = rs.getInt(1);
				String title = rs.getString(2);	//ふたつめの列
				String threadCreateName = rs.getString(3);
				String content = rs.getString(4);
				String date = rs.getString(5);
				String genre = rs.getString(6);
				
				bean.setThreadID(threadID);
				bean.setTitle(title);
				bean.setThreadCreateName(threadCreateName);
				bean.setContent(content);
				bean.setDate(date);
				bean.setGenre(genre);
				
				threads.add(bean);
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
		return threads;
	}
	public void insert(String sql){
		try{
			//Driverインターフェイスを実装するクラスをロードする
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connectionインターフェイスを実装するクラスのインスタンスを返す
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","seikai","seikaipass");
			
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