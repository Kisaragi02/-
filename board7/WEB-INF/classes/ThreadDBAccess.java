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

			//Oracle�ɐڑ�����
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","seikai","seikaipass");
			System.out.println("�ڑ�����");
			
			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st = cn.createStatement();

			//select�������s��//ResultSet�C���^�[�t�F�C�X�����������N���X�̃C���X�^���X���Ԃ�
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
			int threadID = rs.getInt(1);
			String title = rs.getString(2);	//�ӂ��߂̗�
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
		return thread;
	}

	public ArrayList<PostBean> allSelect(String sql){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Oracle�ɐڑ�����
			Connection cn=
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","seikai","seikaipass");
			System.out.println("�ڑ�����");
			
			//Statement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			Statement st=cn.createStatement();

			//select�������s��//ResultSet�C���^�[�t�F�C�X�����������N���X�̃C���X�^���X���Ԃ�
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				PostBean bean = new PostBean();

				int threadID = rs.getInt(1);
				String title = rs.getString(2);	//�ӂ��߂̗�
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
		return threads;
	}
	public void insert(String sql){
		try{
			//Driver�C���^�[�t�F�C�X����������N���X�����[�h����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection�C���^�[�t�F�C�X����������N���X�̃C���X�^���X��Ԃ�
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","seikai","seikaipass");
			
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