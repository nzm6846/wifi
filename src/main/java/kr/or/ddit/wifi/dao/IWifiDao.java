package kr.or.ddit.wifi.dao;

import java.util.List;

import kr.or.ddit.vo.WifiVo;

public interface IWifiDao {
	public List<WifiVo> wifiList();
	public void wifiInsert(WifiVo vo);
}
