package model;

public class SetNumberLogic {
	public void execute(Com com) {
		int num = new java.util.Random().nextInt(99) + 1;
		com.setNumber(num);
		com.setMsg("新しい数を設定しました");
	}
}
