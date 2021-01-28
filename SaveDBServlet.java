import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.Ora;

public class SaveDBServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
		//�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������
		req.setCharacterEncoding("Windows-31J");
		
		//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
		String n=req.getParameter("name");
		String p=req.getParameter("pass");

		Ora _ora = new Ora();
		_ora.insertOra(n, p);
		
		//HttpServletRequest�̎����N���X�̃C���X�^���X�ɓo�^
		req.setAttribute("ora",_ora);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("adduser");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}
