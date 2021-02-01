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
		
		//POST要求によって送信された文字列をクライアントでエンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");
		
		//POST要求によって送信されたパラメータを取得する
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

		//HttpServletRequestの実装クラスのインスタンスに登録する
		req.setAttribute("posts",posts);
		
		//RequestDispatcherインターフェイスを実装するクラスのインスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("postslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}
