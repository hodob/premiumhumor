package applicate;


public class Quizs {
	// 필드
	public int quizsNum;
	public String quiz = "신발이 화나면?!가수비가 덮는 이불은?!신사가 자기소개할때 하는말은?";
	private String answer = "신발끈!컴온요!신사임당";
	 String[] quizs = quiz.split("!");
	String[] answers = answer.split("!");

	// 메소드

	public boolean checkResult(String a, String userAnswer) {
		if(a.equals(userAnswer)) {
			return true;
		} else {
			return false;
		}
	}

}
