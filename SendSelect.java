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

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("�ڑ�����");
			
			//select��
			String sql=" SELECT * FROM board1";

			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);

			/*
			//<�������͒P��f�[�^�����o�����>
			//�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			rs.next();
			String name=rs.getString (1);	//1��ڂ̃f�[�^���擾
			String pass=rs.getString(2);	//2��ڂ̃f�[�^���擾
		
			//bean.setName(name);
			//bean.setPassWord(pass);
			
			//System.out.println(name+"\t"+pass);
			*/
			
			while(rs.next()){
				UserBean bean = new UserBean();
				String name=rs.getString(1);	//1��ڂ̃f�[�^���擾
				String pass=rs.getString(2);	//2��ڂ̃f�[�^���擾
				
				bean.setName(name);
				bean.setPassWord(pass);
				
				user.add(bean);
			}
			
			//Oracle����ؒf����
			cn.close();

			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("�N���X���Ȃ��݂����B");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("SQL�֘A�̗�O�݂����B");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
