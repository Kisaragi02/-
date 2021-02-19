import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class ThreadServlet extends HttpServlet {

	String check = "";
	
	//ArrayList���g�p
	private ArrayList<PostBean> threads = new ArrayList<PostBean>();
	
	//Thread�ꗗ(threadTable)��SELECT���A�S�X���b�h�ꗗ�y�[�W�ɔ�΂�
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");

		String genre = req.getParameter("genre");
		String genreName = genre;

		String sql = "SELECT * FROM thread_sample2 where genre='"+genre+"' ORDER BY threadID desc";

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		threads = _threadDB.allSelect(sql);

		//HttpServletRequest�̎����N���X�̃C���X�^���X�ɂƂ������O�Ńf�[�^��o�^����
		req.setAttribute("threads",threads);
		req.setAttribute("genre",genre);
		req.setAttribute("genreName",genreName);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
		String title = req.getParameter("title");
		String threadCreateName = req.getParameter("threadCreateName");
		String content = req.getParameter("content");
		String genre = req.getParameter("genre");
		String genreName = genre;

		if(threadCreateName == ""){
			threadCreateName = "������";
			System.out.println("null");
		}else{
			System.out.println("not null");
		}

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		
		if(check.equals(content)){
		}
		else{
		//threadID��SEQUENCE�Ŏ�����
		String sql = "INSERT INTO thread_sample2 VALUES(thread_sample_seq2.nextval,'"+title+"','"+threadCreateName+"','"+content+"',default,'"+genre+"')";
		_threadDB.insert(sql);
		}

		String sql = "SELECT * FROM thread_sample2 WHERE genre='"+genre+"' ORDER BY threadID desc";
		threads = _threadDB.allSelect(sql);

		//HttpServletRequest�̎����N���X�̃C���X�^���X�Ƀf�[�^��o�^����
		req.setAttribute("threads",threads);
		req.setAttribute("genre",genre);
		req.setAttribute("genreName",genreName);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
		check = content;
	}
}