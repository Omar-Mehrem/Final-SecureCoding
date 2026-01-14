package finalomarmehrem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCusData {

	public int info(String name, String pass) {

		BufferedReader buffRead = null;
		int count = 1;
		int result = 0;

		Customer cus = new Customer();
		cus.setName(name);
		cus.setPassword(pass);
		try {
			buffRead = new BufferedReader(new FileReader("Customers_User.txt"));

			try {

				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					if (cus.getName().equals(arr[0]) && cus.getPassword().equals(arr[1])) {
						System.out.println(arr[0]  + "," + arr[2] + "," + arr[3] + "\n");
						result = count;
						break;
					}
					count++;
				}

			} finally {

				buffRead.close();

			}

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}

		return result;
	}

	public void updateName(int num, String newName) {

		boolean success = false;
		int count = 1;

		Customer cus = new Customer();
		cus.setName(newName);

		try (BufferedReader buffRead = new BufferedReader(new FileReader("Customers_User.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[0] = cus.getName();

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + ",");
					buffWriter.write(arr[4] + "\n");

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

				File oldFile = new File("Customers_User.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

	public void updatePass(int num, String newPass) {

		boolean success = false;
		int count = 1;

		Customer cus = new Customer();
		cus.setPassword(newPass);

		try (BufferedReader buffRead = new BufferedReader(new FileReader("Customers_User.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[1] = cus.getPassword();

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + ",");
					buffWriter.write(arr[4] + "\n");

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

				File oldFile = new File("Customers_User.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

	public void updatephoneNum(int num, long newPhoneNum) {

		boolean success = false;
		int count = 1;

		Customer cus = new Customer();
		cus.setPhoneNum(newPhoneNum);
		try (BufferedReader buffRead = new BufferedReader(new FileReader("Customers_User.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[2] = String.valueOf(cus.getPhoneNum());

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + ",");
					buffWriter.write(arr[4] + "\n");

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

				File oldFile = new File("Customers_User.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}

		}

	}

	public void updateLicense(int num, long newLicenseNum) {

		boolean success = false;
		int count = 1;

		Customer cus = new Customer();
		cus.setLicenseNum(newLicenseNum);
		try (BufferedReader buffRead = new BufferedReader(new FileReader("Customers_User.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[3] = String.valueOf(cus.getLicenseNum());

					buffWriter.write(arr[0] + ",");
					buffWriter.write(arr[1] + ",");
					buffWriter.write(arr[2] + ",");
					buffWriter.write(arr[3] + ",");
					buffWriter.write(arr[4] + "\n");

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

				File oldFile = new File("Customers_User.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);

				System.out.println("Change successfully");
			}
			}

		}

		
		public void lock(String name, String password) {
			boolean success = false;
			int hash = password.hashCode();
			String hashPassword = String.valueOf(hash);
			
			Customer cus = new Customer();
			cus.setName(name);
			cus.setPassword(password);
			try (BufferedReader buffRead = new BufferedReader(new FileReader("Customers_User.txt"));
					BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

				String line;
				while ((line = buffRead.readLine()) != null) {

					if (cus.getName().equals(name) && cus.getPassword().equals(hashPassword)) {

						String arr[] = line.split(",");
						arr[4] = String.valueOf("Yes");

						buffWriter.write(arr[0] + ",");
						buffWriter.write(arr[1] + ",");
						buffWriter.write(arr[2] + ",");
						buffWriter.write(arr[3] + ",");
						buffWriter.write(arr[4] + "\n");

					} else {

						buffWriter.write(line);
						buffWriter.newLine();

					}
					
				}

				success = true;

			} catch (IOException e) {
				System.out.println("SOMETHING WRONG");
			} finally {

				if (success) {

					File oldFile = new File("Customers_User.txt");
					File newFile = new File("Temp.txt");

					oldFile.delete();
					newFile.renameTo(oldFile);
				}

			}

		
	}

}
