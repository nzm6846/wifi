package kr.or.ddit.wifi.service;

import java.util.List;

import kr.or.ddit.vo.WifiVo;

public interface IWifiService {
	public List<WifiVo> wifiList();
	public void wifiInsert(WifiVo vo);
}
