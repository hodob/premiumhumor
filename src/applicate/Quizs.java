package applicate;


public class Quizs {
	// �ʵ�
	public int quizsNum;
	public String quiz = "�Ź��� ȭ����?!������ ���� �̺���?!�Ż簡 �ڱ�Ұ��Ҷ� �ϴ¸���?";
	private String answer = "�Ź߲�!�Ŀ¿�!�Ż��Ӵ�";
	 String[] quizs = quiz.split("!");
	String[] answers = answer.split("!");

	// �޼ҵ�

	public boolean checkResult(String a, String userAnswer) {
		if(a.equals(userAnswer)) {
			return true;
		} else {
			return false;
		}
	}

}
