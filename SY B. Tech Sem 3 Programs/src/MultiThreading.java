/*Multi Threading:
Write a java program that implements a multi-thread application that has three threads. 
First thread generates random integer every 1 second and if the value is even, 
second thread computes the square of the number and prints. 
If the value is odd, the third thread will print the value of cube of the number.*/
import java.util.Random;

class RandomNumberThread extends Thread {
	
	public void run() {
		
		Random random = new Random();
		System.out.println("10 Random number will be generated.");	//generating random number
		for (int i = 0; i < 10; i++) {
			
			int randomInteger = random.nextInt(100);
			System.out.println("Random Integer generated : " + randomInteger);
			
			if((randomInteger%2) == 0) {		//checking even or odd
				
				System.out.println("The random number generated is even.");
				SquareThread sThread = new SquareThread(randomInteger);		//creating object and running thread for square of number
				sThread.start();
			}
			
			else {
				
				System.out.println("The random number generated is odd.");
				CubeThread cThread = new CubeThread(randomInteger);			//creating object and running thread for cube of number
				cThread.start();
			}
			
			try {
			
				Thread.sleep(1000);
			} 
			
			catch (InterruptedException ex) {
				
				System.out.println(ex);
			}
		}
	}
}

class SquareThread extends Thread {	//thread for square of number
	
	int number;

	SquareThread(int randomNumbern) {
		
		number = randomNumbern;
	}

	public void run() {
		
		System.out.println("Square of " + number + " = " + (number * number));
	}
}

class CubeThread extends Thread { //thread for cube of number
	
	int number;

	CubeThread(int randomNumber) {
	
		number = randomNumber;
	}

	public void run() {
		
		System.out.println("Cube of " + number + " = " + number * number * number);
	}
}

public class MultiThreading {
	
	public static void main(String args[]) {
	
		RandomNumberThread rnThread = new RandomNumberThread();		//creating object and running thread for random number
		rnThread.start();
	}
}