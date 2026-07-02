package model;

public class JudgeLogic {
	public void judge(int user, Com com) {
		String msg = null;
		if (user > com.getNumber()) {
			msg = "大きすぎます";
		} else if (user < com.getNumber()) {
			msg = "小さすぎます";
		} else {
			msg = "あたりです";
		}
		com.setMsg(msg);
	}
}
