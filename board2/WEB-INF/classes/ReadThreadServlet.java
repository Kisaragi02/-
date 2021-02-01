import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tera.PostBean;

public class ReadThreadServlet extends HttpServlet {
	
	//ArrayListを使用
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

		//HttpServletRequestの実装クラスのインスタンスに//usersという名前でデータを登録する
		req.setAttribute("posts",posts);
		
		//RequestDispatcherインターフェイスを実装するクラスの//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("postslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}
