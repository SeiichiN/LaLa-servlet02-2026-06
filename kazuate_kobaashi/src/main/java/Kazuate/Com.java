package Kazuate;

import java.io.Serializable;

public class Com implements Serializable {
	
	//フィールドを設定
	private int comNum;
	
	public void number() {
		int comNum = new java.util.Random().nextInt(100);
		this.comNum = comNum;
	}
	
	//アクセサ
	public int getComNum() { return this.comNum;}
	
}
