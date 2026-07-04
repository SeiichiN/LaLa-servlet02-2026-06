package model;

public class JudgeLogic {

  public JudgeLogic() {
  }

  public void execute(int user, Com com) {
    String msg = "";
    if (user > com.getNumber()) {
      msg = "大きすぎます";
    } else if (user < com.getNumber()) {
      msg = "小さすぎます";
    } else {
      msg = "正解です";
      com.setAtari(true);
    }
    com.setMsg(msg);
  }
}
