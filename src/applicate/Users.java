package applicate;

public class Users {
	// �ʵ�
	private String root = "admin";
	private String rootPass = "qwert123";
	public int passError = 0;

	// �޼ҵ�
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
			System.out.println("�α��� 3ȸ ���� ��������");
			return false;
		} else {
			return true;
		}
	}

}
