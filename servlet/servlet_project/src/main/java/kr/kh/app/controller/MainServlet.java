package kr.kh.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("data");
		String id = request.getParameter("id");
		
		// 화면으로 나이를 전송
		int age = 30;
		// 서버에서 화면으로 전송(화면에서 사용할 이름, 보낼 데이터)
		request.setAttribute("age", age);
		
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

}