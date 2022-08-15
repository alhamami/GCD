import java.util.Scanner;


public class Test {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter number of numbers: ");
		int numbers = keyboard.nextInt();
		System.out.println("");
		int[] mods = new int[numbers];
		int[] remainder = new int[numbers];
		int[] coef = new int[numbers];
		int m = 1;
		int[] crt = new int[numbers];
		int x = 0;
		boolean c = true;
		boolean a =true;
		for (int i = 0; i < numbers; i++) {
			coef[i] = keyboard.nextInt();
			remainder[i] = keyboard.nextInt();
			mods[i] = keyboard.nextInt();
			System.out.println();
		}
		
		keyboard.close();
		for (int i = 0; i < numbers; i++) {
			if (mods[i] <= 0) {
				c = false;

			}
		}
		for(int i=0;i<numbers;i++) {
			if(coef[i]==0)
				a=false;
		}

		GCD Tester = new GCD();
		
		remainder = Tester.convertRemToPositive(remainder, mods);
		remainder = Tester.convertRemainderToSmallest(remainder, mods);
		if (c&&a) {
			for (int i = 0; i < numbers; i++) {
				if (coef[i] < 0) {
					coef[i] *= -1;
					remainder[i] = mods[i] - remainder[i];
				}
			}
			if (Tester.relPrimeSystem(coef, mods, numbers)) {
				if (Tester.RelPrimeMods(mods)) {
					for (int i = 0; i < numbers; i++)
						m *= mods[i];
					for (int i = 0; i < numbers; i++)
						crt[i] = m / mods[i];

					for (int i = 0; i < numbers; i++) {
						if (coef[i] != 1) {
							remainder[i] *= Tester.findModInverse(coef[i], mods[i]);
							coef[i] = 1;
						}
					}
					for (int i = 0; i < numbers; i++) {
						x += remainder[i] * crt[i] * Tester.findModInverse(crt[i], mods[i]);
					}
					x = x % m;
					System.out.println(x);
				} else {
					System.out.println("not solvable");
				}
			} else {
				System.out.println("not solvable");
			}
		} else {
			System.out.println("not solvable");
		}
	}

}
