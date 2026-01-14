package finalomarmehrem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ViewAndUpdateVehicles {

	public void info() {

		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("vehicles.txt"));

			try {
				int i = 1;
				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					System.out.println(i + ") " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "\n");
					i++;
				}

			} finally {
				buffRead.close();
			}

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}
	}
	
	
	public void infoMaintenance() {

		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("vehicles.txt"));

			try {
				int i = 1;
				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");
					
					if(arr[2].equals("Maintenance")) {
					System.out.println(i + ") " + arr[0] + "," + arr[1] + "," + arr[2] + "\n");
					}
					i++;
				}

			} finally {
				buffRead.close();
			}

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}
	}
	

	public void updateModel(int num, String newModel) {

		boolean success = false;
		int count = 1;

		Vehicles ve = new Vehicles();
		ve.setmodel(newModel);
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("vehicles.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[0] = ve.getmodel();

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + "\n");

				} else {

					buffWriter.write(line);
					buffWriter.newLine();

				}
				count++;
			}

			success = true;

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		} finally {

			if (success) {

				File oldFile = new File("vehicles.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

	public void updateLicenseNum(int num, String newLicenseeNum) {

		boolean success = false;
		int count = 1;

		Vehicles ve = new Vehicles();
		ve.setLicenseNum(newLicenseeNum);
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("vehicles.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[1] = ve.getLicenseeNum();

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + "\n");

				} else {

					buffWriter.write(line);
					buffWriter.newLine();

				}
				count++;
			}

			success = true;

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		} finally {

			if (success) {

				File oldFile = new File("vehicles.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

	public void updateStatus(int num, String newStatus) {

		boolean success = false;
		int count = 1;

		Vehicles ve = new Vehicles();
		ve.setStatus(newStatus);
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("vehicles.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[2] = ve.getStatus();

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + "\n");

				} else {

					buffWriter.write(line);
					buffWriter.newLine();

				}
				count++;
			}

			success = true;

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		} finally {

			if (success) {

				File oldFile = new File("vehicles.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

	public void updatePrice(int num, float newPrice) {

		boolean success = false;
		int count = 1;

		Vehicles ve = new Vehicles();
		ve.setPrice(newPrice);
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("vehicles.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[3] = String.valueOf(ve.getPrice());

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + "\n");

				} else {

					buffWriter.write(line);
					buffWriter.newLine();

				}
				count++;
			}

			success = true;

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		} finally {

			if (success) {

				File oldFile = new File("vehicles.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

}
