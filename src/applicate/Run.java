package applicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Run {
	// �ʵ�
	Quizs quizs = new Quizs();
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	String userAnswer;
	boolean gameStatus = false;
	List<String> quizsList = new ArrayList<String>();
	List<String> answerList = new ArrayList<String>();
	int randomNum;
	int correctCount=0;

	// ������
	// ��ü�� �����Ǹ� �������� �ϳ� �����.
	public Run() {

		
		//���� ArrayList�� ����
		for (String s : quizs.quizs) {
			quizsList.add(s);
		}
		//���� ArrayList�� ����
		for (String s : quizs.answers) {
			answerList.add(s);
		}
		//�����Լ� ���� ���� trycatch
		
		//���ӽ���
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

	// ���� �޼ҵ�
	public void run() {
	}

	// ���� ���� �޼ҵ�
	public void startQuizs() {
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
				System.out.println(correctCount+"���� ��� ���߾����ϴ�.");
			} else {
				gameStatus = true;
			}
		} else {
			System.out.println("����");
			System.out.println(correctCount+"���� ���߾����ϴ�.");
			gameStatus=false;
		}
	}
}
