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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String lat = (String) req.getParameter("lat"); // 위도 받아오기
		String lnt = (String) req.getParameter("lnt"); // 경도 받아오기
		System.out.println(lat);
		WifiVo wifi = new WifiVo(); // 가까운 30개의 위도를 불러올 때 리스트에 넘길 파라미터
		
		wifi.setLAT(lat);
		wifi.setLNT(lnt);
		
		List<WifiVo>wifiList = wifiService.wifiList(wifi); // 근처 위치 30곳 와이파이 불러오기
		System.out.println(wifiList);
	}
}
