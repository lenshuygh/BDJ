import java.util.Scanner;

public class DoubleDigitsWithSingleDigitInput extends Thread {
	int num = 0;
	int finalNum = 0;
	boolean sleeping, threadStarted;

	public static void main(String[] args) {
		new DoubleDigitsWithSingleDigitInput();
	}

	DoubleDigitsWithSingleDigitInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("input : ");
		do {
			num = sc.nextInt();
			if (!threadStarted) {
				finalNum = num;
				Thread dr = new Thread(this);
				threadStarted = true;
				dr.start();
			}else {
				if(sleeping) {
					finalNum = (finalNum*10) + num;
				}
			}
			System.out.print("input : ");
		} while (num != -1);
		System.out.println("ENDED");
		sc.close();
	}

	public void run() {
		try {
			sleeping = true;
			System.out.println("startsleep");
			Thread.sleep(1000);
			System.out.println("stopsleep");
			sleeping = false;
			threadStarted = false;
			System.out.println("result => " + finalNum);

		} catch (InterruptedException e) {
		}
	}
}
