package model;

public class LoginLogic {
	public boolean execute(User user) {
		String pass = user.getPass();
		if (pass.equals("1234")) {
			return true;
		}
		return false;
	}
}
