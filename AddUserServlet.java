import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.UserBean;
import tera.SendSelect;

public class AddUserServlet extends HttpServlet {
	
	//ArrayList���g�p
	private ArrayList<UserBean> users = new ArrayList<UserBean>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		/*		
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
		//�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������
		req.setCharacterEncoding("Windows-31J");
		
		//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
		String n=req.getParameter("name");
		String p=req.getParameter("pass");
		
		//UserBean���C���X�^���X�����A�f�[�^���Z�b�g����
		UserBean user=new UserBean();
		user.setName(n);
		user.setPassWord(p);
		
		//���X�g�ɒǉ�����
		users.add(user);
		*/
		
		//SendSelect�N���X�̃I�u�W�F�N�g���g����悤�ɂ���
		SendSelect select = new SendSelect();
		select.setBean();
		users.add(select.getBean());
		/*		
		for(int i=0; i<select.user.size(); i++){
			users.add(select.getBean());
		}*/

		//HttpServletRequest�̎����N���X�̃C���X�^���X��
		//users�Ƃ������O�Ńf�[�^��o�^����
		req.setAttribute("users",users);
		
		//RequestDispatcher�C���^�[�t�F�C�X����������N���X��
		//�C���X�^���X���擾����
		//�����͓]�����URL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("userslist");
		
		//�]����ɗv����]������
		dispatcher.forward(req,res);
	}
}
