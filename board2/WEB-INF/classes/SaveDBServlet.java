import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.PostBean;
import java.util.ArrayList;

public class SaveDBServlet extends HttpServlet {
	private ArrayList<PostBean> posts = new ArrayList<PostBean>();
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g�ŃG���R�[�h�����Ƃ��̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������
		req.setCharacterEncoding("Windows-31J");
		
		//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
		//String threadName=req.getParameter("threadName");
		String name=req.getParameter("name");
		String comment=req.getParameter("comment");

		//String sql = "INSERT INTO "+threadName+"VALUES('"+name+"', '"+comment+"')";
		String sql = "INSERT INTO board1 VALUES('"+name+"','"+comment+"')";

		DBAccess _dbAccess = new DBAccess();

		_dbAccess.doInsert(sql);	//INSERT
		
		sql = "SELECT * FROM board1";
		_dbAccess.doSelect(sql);	//SELECT
		posts = _dbAccess.getSelect();

		//HttpServletRequest�̎����N���X�̃C���X�^���X�ɓo�^����
		req.setAttribute("posts",posts);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X�̃C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher = req.getRequestDispatcher("postslist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}
