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
	
	//ArrayListを使用
	private ArrayList<UserBean> users = new ArrayList<UserBean>();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		/*		
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");
		
		//POST要求によって送信されたパラメータを取得する
		String n=req.getParameter("name");
		String p=req.getParameter("pass");
		
		//UserBeanをインスタンス化し、データをセットする
		UserBean user=new UserBean();
		user.setName(n);
		user.setPassWord(p);
		
		//リストに追加する
		users.add(user);
		*/
		
		//SendSelectクラスのオブジェクトを使えるようにする
		SendSelect select = new SendSelect();
		select.setBean();
		users.add(select.getBean());
		/*		
		for(int i=0; i<select.user.size(); i++){
			users.add(select.getBean());
		}*/

		//HttpServletRequestの実装クラスのインスタンスに
		//usersという名前でデータを登録する
		req.setAttribute("users",users);
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("userslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}
