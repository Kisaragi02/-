import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.PostBean;

public class ReadThreadServlet extends HttpServlet {
	
	//ArrayList���g�p
	private ArrayList<PostBean> posts = new ArrayList<PostBean>();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
		/*String threadName=req.getParameter("threadName");

		PostBean bean = new PostBean();
		bean.setThreadName(threadName);
		String boardName = bean.getThreadName();
		String sql = "SELECT * FROM "+boardName;*/
		String sql = "SELECT * FROM +board1";

		DBAccess _dbAccess = new DBAccess();
		_dbAccess.doSelect(sql);
		posts = _dbAccess.getSelect();

		//HttpServletRequest�̎����N���X�̃C���X�^���X��//users�Ƃ������O�Ńf�[�^��o�^����
		req.setAttribute("posts",posts);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("postslist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}
