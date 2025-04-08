package kr.or.ddit.wifi.service;

import java.util.List;

import kr.or.ddit.vo.WifiVo;
import kr.or.ddit.wifi.dao.WifiDaoImpl;

public class WifiServiceImpl implements IWifiService {
	WifiDaoImpl wifiDao = WifiDaoImpl.getInsatance();
	private static WifiServiceImpl insatance;

	private WifiServiceImpl() {

	}

	public static WifiServiceImpl getInsatance() {
		if (insatance == null) {
			insatance = new WifiServiceImpl();
		}
		return insatance;
	}

	@Override
	public List<WifiVo> wifiList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void wifiInsert(WifiVo vo) {
		// TODO Auto-generated method stub
		wifiDao.wifiInsert(vo);
	}
	
}
