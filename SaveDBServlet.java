import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.Ora;

public class SaveDBServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");
		
		//POST要求によって送信されたパラメータを取得する
		String n=req.getParameter("name");
		String p=req.getParameter("pass");

		Ora _ora = new Ora();
		_ora.insertOra(n, p);
		
		//HttpServletRequestの実装クラスのインスタンスに登録
		req.setAttribute("ora",_ora);
		
		//RequestDispatcherインターフェイスを実装するクラスの
		//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher=
			req.getRequestDispatcher("adduser");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}
