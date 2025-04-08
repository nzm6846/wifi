package kr.or.ddit.wifi.service;

public class WifiServiceImpl implements IWifiService {
	private static WifiServiceImpl insatance;

	private WifiServiceImpl() {

	}

	public static WifiServiceImpl getInsatance() {
		if (insatance == null) {
			insatance = new WifiServiceImpl();
		}
		return insatance;
	}
	
}
