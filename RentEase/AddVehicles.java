package finalomarmehrem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddVehicles {

	public void add() {

		Vehicles veh = new Vehicles();
		Scanner sc = new Scanner(System.in);

		while (veh.getmodel() == null) {
			System.out.println("Enter the model: ");
			String model = sc.next();
			veh.setmodel(model);
		}

		float price = 0;
		while (veh.getPrice() == 0) {

			System.out.println("Enter the price: ");
			try {

				price = sc.nextInt();
				veh.setPrice(price);

			} catch (InputMismatchException e) {
				System.out.println("SOMETHING WRONG");
				sc.next();
			}

		}

		while (veh.getLicenseeNum() == null) {

			System.out.println("Enter the Licnes Number (form xx - xxxxx): ");

			String licenseNum = sc.next();
			veh.setLicenseNum(licenseNum);

		}

		System.out.println("Done");

		BufferedWriter buffWriter = null;
		try {
			buffWriter = new BufferedWriter(new FileWriter("vehicles.txt", true));

			try {
				buffWriter.write(veh.getmodel() + ",");
				buffWriter.write(veh.getLicenseeNum() + ",");
				buffWriter.write("available" + ",");
				buffWriter.write(veh.getPrice() + "\n");

			}catch (IOException e) {
				System.out.println("SOMETHING WRONG");
				
			} finally {
				buffWriter.close();
			}


		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}

	}

}


