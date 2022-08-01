package applicate;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Run {
	// 필드
	Quizs quizs = new Quizs();
	Users users = new Users();
	Random random = new Random();

	Scanner scanner = new Scanner(System.in);
	String userAnswer;
	boolean gameStatus = false;
	List<String> quizsList = new ArrayList<String>();
	List<String> answerList = new ArrayList<String>();
	int randomNum;
	int correctCount = 0;
	boolean admin = false;

	// 생성자
	// 객체가 생성되면 랜덤숫자 하나 만든다.
	public Run() {
		quizsReset();

	}

	public void quizsReset() {
		// 문제 ArrayList에 저장
		for (String s : quizs.quizs) {
			quizsList.add(s);
		}
		// 정답 ArrayList에 저장
		for (String s : quizs.answers) {
			answerList.add(s);
		}
	}

	// 실행 메소드
	public void run() {
		System.out.println("1번 관리자 로그인");
		System.out.println("2번 게임시작");
		System.out.println("3번 프로그램종료");

		int mainNum = scanner.nextInt();
		scanner.nextLine();
		if (mainNum == 1) {
			while (users.getPassError()) {
				System.out.println("아이디를 입력해주세요");
				String login = scanner.nextLine();
				System.out.println("비밀번호를 입력해주세요");
				String pass = scanner.nextLine();
				if (login.equals(users.getRoot()) && pass.equals(users.getRootPass())) {
					admin = true;
					System.out.println("로그인완료");
					adminPage();
					break;
				} else {
					users.setPassError();
					System.out.println("오류 다시입력해주세요");
				}
			}
		} else if (mainNum == 2) {

			// 랜덤함수 오류 방지 trycatch
			try {
				do {
					if (quizsList.size() > 0) {
						randomNum = random.nextInt(quizsList.size());
					}
					// 게임시작

					startQuizs();
					getUserInput();
				} while (gameStatus == true);
			} catch (Exception e) {
			}
		}
		else if (mainNum == 3) {
			System.out.println("프로그램을 종료합니다.");
		}
		scanner.close();
	}

	// 문제 제시 메소드
	public void startQuizs() {
		// 문제 제시
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
				System.out.println(correctCount + "문제 모두 맞추었습니다.");
				System.out.println("메인메뉴로 이동합니다.");
				run();

			} else {
				gameStatus = true;
			}
		} else {
			System.out.println("오답");
			System.out.println(correctCount + "문제 맞추었습니다.");
			gameStatus = false;
			System.out.println("메인메뉴로 이동합니다.");
			run();

		}
		// 게임종료

	}

	public void adminPage() {
		System.out.println("관리자 페이지입니다.");
		System.out.println("1번 문제추가");
		System.out.println("2번 문제삭제");
//		System.out.println("3번 관리자 아이디 비밀번호 변경");
		System.out.println("0번 뒤로가기");
//		System.out.println("4번 유저추가");
//		System.out.println("5번 유저 삭제");
		int adminNum = scanner.nextInt();
		scanner.nextLine();
		switch (adminNum) {
		case 1:
			System.out.println("추가할 문제를 입력해주세요");
			String addQuizInput = scanner.nextLine();
			System.out.println("해당 문제의 답을 입력해주세요");
			String addQuizAnswerInput = scanner.nextLine();
			if (addQuizInput.equals(null) || addQuizAnswerInput.equals(null)) {
				System.out.println("잘못입력하셨습니다.");
				adminPage();
			} else {
				addQuiz(addQuizInput, addQuizAnswerInput);
				adminPage();
			}
			break;
		case 2:
			System.out.println("삭제할 문제 번호를 입력해주세요");
			int removeQuiz = scanner.nextInt();
			quizsList.remove(removeQuiz);
			answerList.remove(removeQuiz);
			System.out.println("삭제완료하였습니다.");
			adminPage();
			break;
		default:
			run();
			break;
		}
	}

	public void addQuiz(String s, String t) {
		quizsList.add(s);
		answerList.add(t);
		System.out.println("문제입력완료");
	}
}
