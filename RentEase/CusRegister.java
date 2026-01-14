package finalomarmehrem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CusRegister {

	public void customerRegister() {

	
		Customer cus = new Customer();
		PasswordPolicy policy = new PasswordPolicy();
		Scanner sc = new Scanner(System.in);

		while (cus.getName() == null) {
			System.out.println("Enter your name: ");
			String cusName = sc.next();
			cus.setName(cusName);
		}


		while (cus.getPhoneNum() == 0) {

			System.out.println("Enter your phone number: ");
			try {

				long phoneNum = sc.nextLong();
				cus.setPhoneNum(phoneNum);

			} catch (InputMismatchException e) {
				System.out.println("SOMETHING WRONG");
				sc.next();
			}

		}

		while (cus.getLicenseNum() == 0) {

			System.out.println("Enter your Licnes Number: ");
			try {

				long licenseNum = sc.nextLong();
				cus.setLicenseNum(licenseNum);

			} catch (InputMismatchException e) {
				System.out.println("SOMETHING WRONG");
				sc.next();
			}

		}
		

		while (cus.getPassword() == null) {
			System.out.println("Enter your password: ");
			String password = sc.next();
			if (PasswordPolicy.isValidPassword(password, policy)) {
			cus.setPassword(password);
			} else {
				System.out.println("Password not valid");
			}
		}

		BufferedWriter buffWriter = null;
		try {
			buffWriter = new BufferedWriter(new FileWriter("Customers_User.txt", true));

			try {
				buffWriter.write(cus.getName() + ",");
				buffWriter.write(cus.getPassword() + ",");
				buffWriter.write(cus.getPhoneNum() + ",");
				buffWriter.write(cus.getLicenseNum() + ",");
				buffWriter.write("No" + "\n"); // locked? 

			} finally {
				buffWriter.close();

			}

//			sc.close();

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}

	}

}