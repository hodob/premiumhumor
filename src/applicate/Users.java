package applicate;

public class Users {
	// 필드
	private String root = "admin";
	private String rootPass = "qwert123";
	public int passError = 0;

	// 메소드
	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getRootPass() {
		return rootPass;
	}

	public void setRootPass(String rootPass) {
		this.rootPass = rootPass;
	}

	public void setPassError() {
		passError++;
	}

	public boolean getPassError() {
		if (passError > 2) {
			System.out.println("로그인 3회 실패 게임종료");
			return false;
		} else {
			return true;
		}
	}

}
