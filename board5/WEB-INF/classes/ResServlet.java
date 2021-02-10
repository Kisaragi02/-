import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class ResServlet extends HttpServlet {
	
	//ArrayListを使用
	private ArrayList<PostBean> thread = new ArrayList<PostBean>();
    private ArrayList<PostBean> posts = new ArrayList<PostBean>();
	
	//渡されたthreadIDに関するThreadTabele（１行）とresTableをそれぞれSELECTし、スレッド詳細ページに飛ばす
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
        int threadID = Integer.parseInt(req.getParameter("threadID"));

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		String sql = "SELECT * FROM thread_sample2 Where threadID="+threadID;
		thread = _threadDB.singleSelect(sql);

        ResDBAccess _resDB = new ResDBAccess();
    	sql = "SELECT * FROM res_sample2 Where threadID="+threadID+"ORDER BY resID desc";
		posts = _resDB.allSelect(sql);

		//HttpServletRequestの実装クラスのインスタンスにデータを登録する
		req.setAttribute("thread",thread);
		req.setAttribute("posts",posts);
        
		
		//RequestDispatcherインターフェイスを実装するクラスの//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("reslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}

	//スレッド詳細ページで入力されたパラメータを取得し、insert後、DoPost()と同じくselectする
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
		
		int threadID = Integer.parseInt(req.getParameter("threadID"));
		String resName = req.getParameter("resName");
		String resContent = req.getParameter("resContent");

		if(resName == ""){
			resName = "名無し";
		}

		ThreadDBAccess _threadDB = new ThreadDBAccess();
		ResDBAccess _resDB = new ResDBAccess();

		//resIDの取得
		String sql = "SELECT COUNT(*) FROM res_sample2 WHERE threadID = "+threadID;
		int count = _resDB.resCount(sql);
		int resID = count + 1;

		sql = "INSERT INTO res_sample2 VALUES("+threadID+", "+resID+", '"+resName+"', '"+resContent+"', default)";
		_threadDB.insert(sql);

		sql = "SELECT * FROM thread_sample2 Where threadID = "+threadID;
		thread = _threadDB.singleSelect(sql);

        sql = "SELECT * FROM res_sample2 Where threadID = "+threadID+"ORDER BY resID desc";
		posts = _resDB.allSelect(sql);

		//HttpServletRequestの実装クラスのインスタンスにデータを登録する
		req.setAttribute("posts",posts);
		req.setAttribute("thread",thread);
		
		//RequestDispatcherインターフェイスを実装するクラスの//インスタンスを取得する
		//引数は転送先のURL
		RequestDispatcher dispatcher = req.getRequestDispatcher("reslist");
		
		//転送先に要求を転送する
		dispatcher.forward(req,res);
	}
}