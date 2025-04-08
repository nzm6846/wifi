package kr.or.ddit.wifi.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.vo.WifiVo;
import kr.or.ddit.wifi.service.WifiServiceImpl;

@WebServlet("/main.do")
public class MainController extends HttpServlet {
	WifiServiceImpl wifiService = WifiServiceImpl.getInsatance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ctx = req.getServletContext();
		ctx.getRequestDispatcher("/WEB-INF/view/wifi/main.jsp").forward(req, resp);
		
	}
	

}
