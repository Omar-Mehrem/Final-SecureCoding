package finalomarmehrem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddRentalAgents {

	public void add() {

		RentalAgent ren = new RentalAgent();
	    PasswordPolicy policy = new PasswordPolicy();
		Scanner sc = new Scanner(System.in);

		while (ren.getName() == null) {
			System.out.println("Enter the staff name: ");
			String name = sc.next();
			ren.setName(name);
		}

		int phoneNum = 0;
		while (ren.getPhoneNum() == 0) {

			System.out.println("Enter the staff phone number: ");
			try {

				phoneNum = sc.nextInt();
				ren.setPhoneNum(phoneNum);

			} catch (InputMismatchException e) {
				System.out.println("SOMETHING WRONG");
				sc.next();
			}

		}
		
		while (ren.getPassword() == null) {
			System.out.println("Enter the staff password: ");
			String password = sc.next();
			
			if (PasswordPolicy.isValidPassword(password, policy)) {
			ren.setPassword(password);
			} else {
				System.out.println("Password not valid");
			}
		}

		System.out.println("Done");

		BufferedWriter buffWriter = null;
		try {
			buffWriter = new BufferedWriter(new FileWriter("RentalAgent.txt", true));

			try {
				buffWriter.write(ren.getName() + ",");
				buffWriter.write(ren.getPhoneNum() + ",");
				buffWriter.write(ren.getPassword() + "\n");

			}catch (IOException e) {
				System.out.println("SOMETHING WRONG");
				
			} finally {
				buffWriter.close();

			}

//			sc.close();

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}

	}

}
