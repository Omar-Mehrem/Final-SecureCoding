package finalomarmehrem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ViewAndUpdateMainteneance {

	public void info() {

		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("Maintenance_Staff.txt"));

			try {
				int i = 1;
				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					System.out.println(i + ") " + arr[0] + "," + arr[1] + "," + arr[2] + "\n");
					i++;
				}

			} finally {
				buffRead.close();
			}

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}
	}

	public void updateName(int num, String newName) {

		boolean success = false;
		int count = 1;

		MaintenanceStaff ms = new MaintenanceStaff();
		ms.setName(newName);
		
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("Maintenance_Staff.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[0] = ms.getName();

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

				File oldFile = new File("Maintenance_Staff.txt");
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

		MaintenanceStaff ms = new MaintenanceStaff();
		ms.setPhoneNum(newPhoneNum);
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("Maintenance_Staff.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[1] = String.valueOf(ms.getPhoneNum());

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

				File oldFile = new File("Maintenance_Staff.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);
				
				System.out.println("Change successfully");
			}

		}

	}
	
	
	public void updateLicense(int num, Long newLicense) {

		boolean success = false;
		int count = 1;

		MaintenanceStaff ms = new MaintenanceStaff();
		ms.setLicenseNum(newLicense);
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("Maintenance_Staff.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[2] = String.valueOf(ms.getLicenseNum());

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

				File oldFile = new File("Maintenance_Staff.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);
				
				System.out.println("Change successfully");
			}

		}

	}

}
