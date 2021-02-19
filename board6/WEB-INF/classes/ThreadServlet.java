import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class ThreadServlet extends HttpServlet {

	String check = "";
	
	//ArrayListを使用
	private ArrayList<PostBean> threads = new ArrayList<PostBean>();
	
	//Thread一覧(threadTable)をSELECTし、全スレッド一覧ページに飛ばす
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");

		String genre = req.getParameter("genre");
		String genreName = genre;

		String sql = "SELECT * FROM thread_sample2 where genre='"+genre+"' ORDER BY threadID desc";

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		threads = _threadDB.allSelect(sql);

		//HttpServletRequestの実装クラスのインスタンスにという名前でデータを登録する
		req.setAttribute("threads",threads);
		req.setAttribute("genre",genre);
		req.setAttribute("genreName",genreName);
		
		//RequestDispatcherインターフェイスを実装するクラスのインスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
		String title = req.getParameter("title");
		String threadCreateName = req.getParameter("threadCreateName");
		String content = req.getParameter("content");
		String genre = req.getParameter("genre");
		String genreName = genre;

		if(threadCreateName == ""){
			threadCreateName = "名無し";
			System.out.println("null");
		}else{
			System.out.println("not null");
		}

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		
		if(check.equals(content)){
		}
		else{
		//threadIDはSEQUENCEで自動化
		String sql = "INSERT INTO thread_sample2 VALUES(thread_sample_seq2.nextval,'"+title+"','"+threadCreateName+"','"+content+"',default,'"+genre+"')";
		_threadDB.insert(sql);
		}

		String sql = "SELECT * FROM thread_sample2 WHERE genre='"+genre+"' ORDER BY threadID desc";
		threads = _threadDB.allSelect(sql);

		//HttpServletRequestの実装クラスのインスタンスにデータを登録する
		req.setAttribute("threads",threads);
		req.setAttribute("genre",genre);
		req.setAttribute("genreName",genreName);
		
		//RequestDispatcherインターフェイスを実装するクラスのインスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("threadlist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
		check = content;
	}
}