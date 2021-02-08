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

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("�ڑ�����");
			
			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��//ResultSet�C���^�[�t�F�C�X�����������N���X�̃C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				PostBean bean = new PostBean();

				int threadID = rs.getInt(1);
				int resID=rs.getInt(2);	//��ڂ̗�
				String resContent=rs.getString(3);	
				
				bean.setThreadID(threadID);
				bean.setResID(resID);
				bean.setResContent(resContent);
				
				replies.add(bean);
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
		return replies;
	}
	public void insert(String sql){
		try{
			//Driver�C���^�[�t�F�C�X����������N���X�����[�h����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X��Ԃ�
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			
			//�����R�~�b�g��OFF�ɂ���
			cn.setAutoCommit(false);
			
			System.out.println("�ڑ�����");
			
			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			Statement st=cn.createStatement();
			
			//SQL�����s���g�����U�N�V�������J�n�����B�����������Ԃ����
			int count=st.executeUpdate(sql);
			
			System.out.println(count+"����������");
			
			//�g�����U�N�V�������R�~�b�g����
			cn.commit();
			
			//�X�e�[�g�����g���N���[�Y����
			st.close();
			
			//RDBMS����ؒf����
			cn.close();
			
			System.out.println("�ؒf����");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}