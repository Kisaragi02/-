import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class ThreadServlet extends HttpServlet {
	
	//ArrayList���g�p
	private ArrayList<PostBean> threads = new ArrayList<PostBean>();
	
	//Thread�ꗗ(threadTable)��SELECT���A�S�X���b�h�ꗗ�y�[�W�ɔ�΂�
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");

		String sql = "SELECT * FROM thread_sample1";

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		threads = _threadDB.allSelect(sql);

		//HttpServletRequest�̎����N���X�̃C���X�^���X�ɂƂ������O�Ńf�[�^��o�^����
		req.setAttribute("threads",threads);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		ThreadDBAccess _threadDB = new ThreadDBAccess();

		String sql = "INSERT INTO thread_sample1 VALUES(3, '"+title+"', '"+content+"')";
		_threadDB.insert(sql);

		sql = "SELECT * FROM thread_sample1";
		threads = _threadDB.allSelect(sql);

		//HttpServletRequest�̎����N���X�̃C���X�^���X�Ƀf�[�^��o�^����
		req.setAttribute("threads",threads);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}