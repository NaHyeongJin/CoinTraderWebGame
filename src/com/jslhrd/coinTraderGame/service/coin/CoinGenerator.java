package com.jslhrd.coinTraderGame.service.coin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import com.jslhrd.coinTraderGame.model.coin.CoinDAO;

public class CoinGenerator {
	static private final int COIN_NUMBER = 4;
	static private final int LOW_VALUE = 25;
	static private final int HIGH_VALUE = 200;

	static private CoinGenerator instance;

	static private Date lastUpdateDate;
	static private int[][] coinPrices = new int[COIN_NUMBER][70];

	public int[][] getCoinPrices() {
		return coinPrices;
	}

	static private int[] maxUp = new int[COIN_NUMBER];
	static private int[] minUp = new int[COIN_NUMBER];
	static private int[] maxDown = new int[COIN_NUMBER];
	static private int[] minDown = new int[COIN_NUMBER];
	static private int[] upPer = new int[COIN_NUMBER];
	static private int[] keepPer = new int[COIN_NUMBER];
	static private int[] downPer = new int[COIN_NUMBER];

	private CoinGenerator() {
		upPer[0] = 40;
		upPer[1] = 40;
		upPer[2] = 80;
		upPer[3] = 10;

		keepPer[0] = 20;
		keepPer[1] = 20;
		keepPer[2] = 10;
		keepPer[3] = 10;

		downPer[0] = 40;
		downPer[1] = 40;
		downPer[2] = 10;
		downPer[3] = 80;
		
		maxUp[0] = LOW_VALUE;
		maxUp[1] = HIGH_VALUE;
		maxUp[2] = LOW_VALUE;
		maxUp[3] = HIGH_VALUE;
		
		minUp[0] = maxUp[0] / 5;
		minUp[1] = maxUp[1] / 5;
		minUp[2] = maxUp[2] / 5;
		minUp[3] = maxUp[3] / 5;
		
		maxDown[0] = LOW_VALUE;
		maxDown[1] = HIGH_VALUE;
		maxDown[2] = HIGH_VALUE;
		maxDown[3] = LOW_VALUE;
		
		minDown[0] = maxDown[0] / 5;
		minDown[1] = maxDown[1] / 5;
		minDown[2] = maxDown[2] / 5;
		minDown[3] = maxDown[3] / 5;
	}
	
	public void run() {
		CoinDAO manager = CoinDAO.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			lastUpdateDate = manager.coinUpdateDate().equals("") ? new Date() : format1.parse(manager.coinUpdateDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		coinPrices = manager.coinPrices();
		for (int i = 0; i < COIN_NUMBER; i++) {
			coinPrices[i] = CoinPriceGenerator(lastUpdateDate, coinPrices[i], maxUp[i], minUp[i], maxDown[i],
					minDown[i], upPer[i], keepPer[i], downPer[i]);
			if (i == COIN_NUMBER - 1)
				manager.addPrices(coinPrices);
		}
	}

	static public CoinGenerator getInstance() {
		if (instance == null)
			instance = new CoinGenerator();
		return instance;
	}

	static private int[] CoinPriceGenerator(Date lastUpdateDate, int[] prices, int maxUp, int minUp, int maxDown, int minDown,
			int upPer, int keepPer, int downPer) {
		int cnt = 0;
		long dif = (new Date().getTime() - lastUpdateDate.getTime()) / 1000; // 현재시간 - 마지막 업데이트 시간
		dif = (dif > 70) ? 70 : dif;
		if (dif == 0) {
			return prices;
		}
		for (int i = 0; i < prices.length - (int) dif; i++) {
			prices[i] = prices[(int) dif + i];
			cnt++;
		}
		if (cnt == 0) {
			prices[0] = prices[69];
			cnt++;
		}
		for (int i = cnt; i < prices.length; i++) {
			int rand = (int) Math.round(Math.random() * 100); // 0~100 사이 랜덤 수 설정
			if (rand < downPer) {
				prices[i] = prices[i - 1] - (int) Math.round(Math.random() * (maxDown - minDown)) - minDown;
				prices[i] = (prices[i] < 0) ? 0 : prices[i]; // 0원 미만이면 0원으로 설정
			} // 감소
			else if (rand < downPer + keepPer) {
				prices[i] = prices[i - 1];
			} // 유지
			else {
				prices[i] = prices[i - 1] + (int) Math.round(Math.random() * (maxUp - minUp)) + minUp;
			} // 상승
		} // 확률에 따라 prices 가격 바꿔서 배열에 저장
		return prices;
	}
}
