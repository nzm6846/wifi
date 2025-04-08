package kr.or.ddit.wifi.dao;

import java.util.List;

import kr.or.ddit.util.MybatisDao;
import kr.or.ddit.vo.WifiVo;

public class WifiDaoImpl extends MybatisDao implements IWifiDao {
	private static WifiDaoImpl insatance;

	
	private WifiDaoImpl() {

	}

	public static WifiDaoImpl getInsatance() {
		if (insatance == null) {
			insatance = new WifiDaoImpl();
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
		 update("Wifi.wifiInsert",vo);
	}

	
}
