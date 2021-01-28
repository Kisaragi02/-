package tera;

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


public class SendSelect extends UserBean{
	
	public ArrayList<UserBean> user = new ArrayList<UserBean>();
	
	public ArrayList<UserBean> getBean(){
		return user;
	}
	
	public void setBean(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracleに接続する
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("接続完了");
			
			//select文
			String sql=" SELECT * FROM board1";

			//Statementインターフェイスを実装するクラスをインスタンス化する
			Statement st=cn.createStatement();

			//select文を実行し
			//ResultSetインターフェイスを実装したクラスの
			//インスタンスが返る
			ResultSet rs=st.executeQuery(sql);

			/*
			//<こっちは単一データを取り出すやつ>
			//カーソルを一行だけスクロールし、データをフェッチする
			rs.next();
			String name=rs.getString (1);	//1列目のデータを取得
			String pass=rs.getString(2);	//2列目のデータを取得
		
			//bean.setName(name);
			//bean.setPassWord(pass);
			
			//System.out.println(name+"\t"+pass);
			*/
			
			while(rs.next()){
				UserBean bean = new UserBean();
				String name=rs.getString(1);	//1列目のデータを取得
				String pass=rs.getString(2);	//2列目のデータを取得
				
				bean.setName(name);
				bean.setPassWord(pass);
				
				user.add(bean);
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
	}
}
