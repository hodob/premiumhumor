package applicate;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Run {
	// �ʵ�
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

	// ������
	// ��ü�� �����Ǹ� �������� �ϳ� �����.
	public Run() {
		quizsReset();

	}

	public void quizsReset() {
		// ���� ArrayList�� ����
		for (String s : quizs.quizs) {
			quizsList.add(s);
		}
		// ���� ArrayList�� ����
		for (String s : quizs.answers) {
			answerList.add(s);
		}
	}

	// ���� �޼ҵ�
	public void run() {
		System.out.println("1�� ������ �α���");
		System.out.println("2�� ���ӽ���");
		System.out.println("3�� ���α׷�����");

		int mainNum = scanner.nextInt();
		scanner.nextLine();
		if (mainNum == 1) {
			while (users.getPassError()) {
				System.out.println("���̵� �Է����ּ���");
				String login = scanner.nextLine();
				System.out.println("��й�ȣ�� �Է����ּ���");
				String pass = scanner.nextLine();
				if (login.equals(users.getRoot()) && pass.equals(users.getRootPass())) {
					admin = true;
					System.out.println("�α��οϷ�");
					adminPage();
					break;
				} else {
					users.setPassError();
					System.out.println("���� �ٽ��Է����ּ���");
				}
			}
		} else if (mainNum == 2) {

			// �����Լ� ���� ���� trycatch
			try {
				do {
					if (quizsList.size() > 0) {
						randomNum = random.nextInt(quizsList.size());
					}
					// ���ӽ���

					startQuizs();
					getUserInput();
				} while (gameStatus == true);
			} catch (Exception e) {
			}
		}
		else if (mainNum == 3) {
			System.out.println("���α׷��� �����մϴ�.");
		}
		scanner.close();
	}

	// ���� ���� �޼ҵ�
	public void startQuizs() {
		// ���� ����
		System.out.println(quizsList.get(randomNum));

	}

	public void getUserInput() {

		userAnswer = scanner.nextLine();
		if (answerList.get(randomNum).equals(userAnswer)) {
			System.out.println("����");
			correctCount++;
			quizsList.remove(randomNum);
			answerList.remove(randomNum);
			try {
				randomNum = random.nextInt(quizsList.size());
			} catch (Exception e) {

			}
			if (quizsList.size() == 0) {
				System.out.println("�ٸ��� ��������");
				System.out.println(correctCount + "���� ��� ���߾����ϴ�.");
				System.out.println("���θ޴��� �̵��մϴ�.");
				run();

			} else {
				gameStatus = true;
			}
		} else {
			System.out.println("����");
			System.out.println(correctCount + "���� ���߾����ϴ�.");
			gameStatus = false;
			System.out.println("���θ޴��� �̵��մϴ�.");
			run();

		}
		// ��������

	}

	public void adminPage() {
		System.out.println("������ �������Դϴ�.");
		System.out.println("1�� �����߰�");
		System.out.println("2�� ��������");
//		System.out.println("3�� ������ ���̵� ��й�ȣ ����");
		System.out.println("0�� �ڷΰ���");
//		System.out.println("4�� �����߰�");
//		System.out.println("5�� ���� ����");
		int adminNum = scanner.nextInt();
		scanner.nextLine();
		switch (adminNum) {
		case 1:
			System.out.println("�߰��� ������ �Է����ּ���");
			String addQuizInput = scanner.nextLine();
			System.out.println("�ش� ������ ���� �Է����ּ���");
			String addQuizAnswerInput = scanner.nextLine();
			if (addQuizInput.equals(null) || addQuizAnswerInput.equals(null)) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				adminPage();
			} else {
				addQuiz(addQuizInput, addQuizAnswerInput);
				adminPage();
			}
			break;
		case 2:
			System.out.println("������ ���� ��ȣ�� �Է����ּ���");
			int removeQuiz = scanner.nextInt();
			quizsList.remove(removeQuiz);
			answerList.remove(removeQuiz);
			System.out.println("�����Ϸ��Ͽ����ϴ�.");
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
		System.out.println("�����Է¿Ϸ�");
	}
}
