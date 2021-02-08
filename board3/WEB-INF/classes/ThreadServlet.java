import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class ThreadServlet extends HttpServlet {
	
	//ArrayListを使用
	private ArrayList<PostBean> threads = new ArrayList<PostBean>();
	
	//Thread一覧(threadTable)をSELECTし、全スレッド一覧ページに飛ばす
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");

		String sql = "SELECT * FROM thread_sample1";

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		threads = _threadDB.allSelect(sql);

		//HttpServletRequestの実装クラスのインスタンスにという名前でデータを登録する
		req.setAttribute("threads",threads);
		
		//RequestDispatcherインターフェイスを実装するクラスのインスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//転送先に要求を転送する
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

		//HttpServletRequestの実装クラスのインスタンスにデータを登録する
		req.setAttribute("threads",threads);
		
		//RequestDispatcherインターフェイスを実装するクラスのインスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}