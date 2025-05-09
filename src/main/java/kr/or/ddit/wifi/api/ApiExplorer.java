package kr.or.ddit.wifi.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.or.ddit.vo.WifiVo;
import kr.or.ddit.wifi.service.WifiServiceImpl;

public class ApiExplorer {
	public static void main(String[] args) throws IOException {
		int start=1;
		int end=10;
		int total=0;
		WifiServiceImpl wifiService = WifiServiceImpl.getInsatance();
		 do  {
			
			StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
			urlBuilder.append("/" +  URLEncoder.encode("74626f746879707532354c6343456b","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
			urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
			urlBuilder.append("/" + URLEncoder.encode(String.valueOf(start),"UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
			urlBuilder.append("/" + URLEncoder.encode(String.valueOf(end),"UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
			// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
			
			// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
			//urlBuilder.append("/" + URLEncoder.encode("20220301","UTF-8")); /* 서비스별 추가 요청인자들*/
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
			BufferedReader rd;
			
			// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			//System.out.println(sb.toString());
			
			JsonParser jsonParser = new JsonParser();
			JsonObject jobj = (JsonObject) jsonParser.parse(sb.toString());
			JsonObject jsrow = (JsonObject) jobj.get("TbPublicWifiInfo");
			
			if(total==0) {
				
				total = jsrow.get("list_total_count").getAsInt();
			}
			
//			System.out.println(total);
			JsonArray  jsarr = (JsonArray) jsrow.get("row");
			
			Gson gson = new Gson();
			
			for(int i=0; i<jsarr.size(); i++) {
				JsonObject obj = (JsonObject) jsarr.get(i);
				WifiVo vo = gson.fromJson(obj.toString(), WifiVo.class);
				wifiService.wifiInsert(vo);

			} 
			
			start +=10;
			end+=10;
		}  while(start<=total); 
	}
}