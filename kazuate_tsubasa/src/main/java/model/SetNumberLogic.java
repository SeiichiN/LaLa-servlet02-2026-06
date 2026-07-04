package model;

public class SetNumberLogic {

	public SetNumberLogic() {
	}

	public void execute(Com com) {
		int comNum = new java.util.Random().nextInt(99) + 1;
		com.setNumber(comNum);
	}
}
