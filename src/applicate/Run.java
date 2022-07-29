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
	int randomNum=2;
	
	
	// 생성자
	// 객체가 생성되면 랜덤숫자 하나 만든다.
	public Run() {

		for (String s : quizs.quizs) {
			quizsList.add(s);
		}
		for (String s : quizs.answers) {
			answerList.add(s);
		}
		
		do {
			if(quizsList.size()>0) {
				randomNum = random.nextInt(quizsList.size());
				System.out.println("test");
			}else System.out.println(quizsList.size());
			startQuizs();
			getUserInput();
		} while (gameStatus == true);
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
			quizsList.remove(randomNum);
			answerList.remove(randomNum);
			try {
				randomNum = random.nextInt(quizsList.size());
			} catch (Exception e) {
				
			}
			if (quizsList.size() == 0) {
				System.out.println("다맞춤 게임종료");
			} else {
				gameStatus = true;
			}
		} else {
			System.out.println("틀림");
		}
	}
}
