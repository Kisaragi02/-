import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class ResServlet extends HttpServlet {
	
	//ArrayList���g�p
	private ArrayList<PostBean> thread = new ArrayList<PostBean>();
    private ArrayList<PostBean> posts = new ArrayList<PostBean>();
	
	//�n���ꂽthreadID�Ɋւ���ThreadTabele�i�P�s�j��resTable�����ꂼ��SELECT���A�X���b�h�ڍ׃y�[�W�ɔ�΂�
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
        int threadID = Integer.parseInt(req.getParameter("threadID"));

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		String sql = "SELECT * FROM thread_sample1 Where threadID="+threadID;
		thread = _threadDB.singleSelect(sql);

        ResDBAccess _resDB = new ResDBAccess();
    	sql = "SELECT * FROM res_sample1 Where threadID="+threadID;
		posts = _resDB.allSelect(sql);

		//HttpServletRequest�̎����N���X�̃C���X�^���X�Ƀf�[�^��o�^����
		req.setAttribute("thread",thread);
		req.setAttribute("posts",posts);
        
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("reslist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}

	//�X���b�h�ڍ׃y�[�W�œ��͂��ꂽ�p�����[�^���擾���Ainsert��ADoPost()�Ɠ�����select����
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
        //String threadID = req.getParameter("threadID");
		int threadID = Integer.parseInt(req.getParameter("threadID"));
		String resContent = req.getParameter("resContent");

		ThreadDBAccess _threadDB = new ThreadDBAccess();

		//String sql = "INSERT INTO res_sample1(resContent) VALUES('"+resContent+"')";
		String sql = "INSERT INTO res_sample1 VALUES("+threadID+", 2, '"+resContent+"')";
		//String sql = "INSERT INTO res_sample1(threadID) VALUES("+threadID+")";
		_threadDB.insert(sql);

		sql = "SELECT * FROM thread_sample1 Where threadID = "+threadID;
		thread = _threadDB.singleSelect(sql);

        ResDBAccess _resDB = new ResDBAccess();
        sql = "SELECT * FROM res_sample1 Where threadID = "+threadID;
		posts = _resDB.allSelect(sql);

		//HttpServletRequest�̎����N���X�̃C���X�^���X�Ƀf�[�^��o�^����
		req.setAttribute("posts",posts);
		req.setAttribute("thread",thread);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("reslist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}