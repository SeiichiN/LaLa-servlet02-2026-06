package model;

public class Com {

	private int number;
	private String msg;
	private boolean atari;

	public Com() {
		this.atari = false;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int numbeer) {
		this.number = numbeer;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isAtari() {
		return atari;
	}

	public void setAtari(boolean atari) {
		this.atari = atari;
	}
}
