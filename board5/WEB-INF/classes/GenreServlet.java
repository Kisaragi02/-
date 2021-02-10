import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;

public class GenreServlet extends HttpServlet {
	
	//ArrayList‚ðŽg—p
	private ArrayList<PostBean> thread1 = new ArrayList<PostBean>();
    private ArrayList<PostBean> thread2 = new ArrayList<PostBean>();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	

		req.setCharacterEncoding("Windows-31J");
        ThreadDBAccess _threadDB = new ThreadDBAccess();

		//String sql = "SELECT * FROM thread_sample2 where genre='other' ORDER BY threadID desc";
		//thread1 = _threadDB.singleSelect(sql);
        //req.setAttribute("thread1",thread1);
        req.setAttribute("thread1",_threadDB.singleSelect("SELECT * FROM thread_sample2 where genre='other' ORDER BY threadID desc"));
        //req.setAttribute("thread2",_threadDB.singleSelect("SELECT * FROM thread_sample2 where genre='hobby' ORDER BY threadID asc"));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("top");
		dispatcher.forward(req,res);
	}
}