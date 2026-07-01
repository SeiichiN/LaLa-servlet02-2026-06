package model;

public class KazuLogic {
	public void execute(Kazu kazu) {
		if (kazu.getUser() > kazu.getCom()) {
			kazu.setMsg("大きすぎます");
		} else if (kazu.getUser() < kazu.getCom()) {
			kazu.setMsg("小さすぎます");
		} else {
			kazu.setMsg("当たりです");
		}
	}
}
