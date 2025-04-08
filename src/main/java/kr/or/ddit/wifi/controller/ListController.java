package kr.or.ddit.wifi.controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.or.ddit.vo.WifiVo;
import kr.or.ddit.wifi.service.WifiServiceImpl;

@WebServlet("/List")
public class ListController extends HttpServlet {
	WifiServiceImpl wifiService = WifiServiceImpl.getInsatance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String lat = (String) req.getParameter("lat"); // 위도 받아오기
		String lnt = (String) req.getParameter("lnt"); // 경도 받아오기
		System.out.println(lat);
		WifiVo wifi = new WifiVo(); // 가까운 30개의 위도를 불러올 때 리스트에 넘길 파라미터
		
		wifi.setLAT(lat);
		wifi.setLNT(lnt);
		

		List<WifiVo>wifiList = wifiService.wifiList(wifi); // 근처 위치 30곳 와이파이 불러오기
		System.out.println(wifiList);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json"); // ✅ 오타 수정됨

		// ✅ Gson으로 객체를 JSON 문자열로 변환
		Gson gson = new Gson();
		String json = gson.toJson(wifiList);

		resp.getWriter().write(json);
//		JsonArray jsonArray = new JsonArray();
//		for(WifiVo wifi1 : wifiList) {
//			JsonObject obj = new JsonObject();
//			obj.addProperty("X_SWIFI_MGR_NO", wifi1.getX_SWIFI_MGR_NO());
//			obj.addProperty("X_SWIFI_WRDOFC", wifi1.getX_SWIFI_WRDOFC());
//			obj.addProperty("X_SWIFI_MAIN_NM", wifi1.getX_SWIFI_MAIN_NM());
//			obj.addProperty("X_SWIFI_ADRES1", wifi1.getX_SWIFI_ADRES1());
//			obj.addProperty("X_SWIFI_ADRES2", wifi1.getX_SWIFI_ADRES2());
//			obj.addProperty("X_SWIFI_INSTL_FLOOR", wifi1.getX_SWIFI_INSTL_FLOOR());
//			obj.addProperty("X_SWIFI_INSTL_TY", wifi1.getX_SWIFI_INSTL_TY());
//			obj.addProperty("X_SWIFI_INSTL_MBY", wifi1.getX_SWIFI_INSTL_MBY());
//			obj.addProperty("X_SWIFI_SVC_SE", wifi1.getX_SWIFI_SVC_SE());
//			obj.addProperty("X_SWIFI_CMCWR", wifi1.getX_SWIFI_CMCWR());
//			obj.addProperty("X_SWIFI_CNSTC_YEAR", wifi1.getX_SWIFI_CNSTC_YEAR());
//			obj.addProperty("X_SWIFI_INOUT_DOOR", wifi1.getX_SWIFI_INOUT_DOOR());
//			obj.addProperty("X_SWIFI_REMARS3", wifi1.getX_SWIFI_REMARS3());
//			obj.addProperty("LAT", wifi1.getLAT());
//			obj.addProperty("LNT", wifi1.getLNT());
//			obj.addProperty("WORK_DTTM", wifi1.getWORK_DTTM());
//			
//			jsonArray.add(obj);
//		}

	}
}
