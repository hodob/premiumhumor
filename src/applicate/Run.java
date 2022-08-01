package applicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Run {
	// 필드
	Quizs quizs = new Quizs();
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	String userAnswer;
	boolean gameStatus = false;
	List<String> quizsList = new ArrayList<String>();
	List<String> answerList = new ArrayList<String>();
	int randomNum;
	int correctCount=0;

	// 생성자
	// 객체가 생성되면 랜덤숫자 하나 만든다.
	public Run() {

		
		//문제 ArrayList에 저장
		for (String s : quizs.quizs) {
			quizsList.add(s);
		}
		//정답 ArrayList에 저장
		for (String s : quizs.answers) {
			answerList.add(s);
		}
		//랜덤함수 오류 방지 trycatch
		
		//게임시작
		try {
			do {
				if (quizsList.size() > 0) {
					randomNum = random.nextInt(quizsList.size());
				} 
				startQuizs();
				getUserInput();
			} while (gameStatus == true);
		} catch (Exception e) {

		}

	}

	// 실행 메소드
	public void run() {
	}

	// 문제 제시 메소드
	public void startQuizs() {
		System.out.println(quizsList.get(randomNum));
	}

	public void getUserInput() {
		userAnswer = scanner.nextLine();
		if (answerList.get(randomNum).equals(userAnswer)) {
			System.out.println("정답");
			correctCount++;
			quizsList.remove(randomNum);
			answerList.remove(randomNum);
			try {
				randomNum = random.nextInt(quizsList.size());
			} catch (Exception e) {

			}
			if (quizsList.size() == 0) {
				System.out.println("다맞춤 게임종료");
				System.out.println(correctCount+"문제 모두 맞추었습니다.");
			} else {
				gameStatus = true;
			}
		} else {
			System.out.println("오답");
			System.out.println(correctCount+"문제 맞추었습니다.");
			gameStatus=false;
		}
	}
}
