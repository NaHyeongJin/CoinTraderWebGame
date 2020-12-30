package com.jslhrd.coinTraderGame.model.coin;

public class CoinVO {
	private int[] coin1;
	private int[] coin2;
	private int[] coin3;
	private int[] coin4;
	private String lastUpdateDate;
	
	public int[] getCoin1() {
		return coin1;
	}
	public void setCoin1(int[] coin1) {
		this.coin1 = coin1;
	}
	public int[] getCoin2() {
		return coin2;
	}
	public void setCoin2(int[] coin2) {
		this.coin2 = coin2;
	}
	public int[] getCoin3() {
		return coin3;
	}
	public void setCoin3(int[] coin3) {
		this.coin3 = coin3;
	}
	public int[] getCoin4() {
		return coin4;
	}
	public void setCoin4(int[] coin4) {
		this.coin4 = coin4;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}
