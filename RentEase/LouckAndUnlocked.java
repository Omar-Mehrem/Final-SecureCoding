package finalomarmehrem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LouckAndUnlocked {

	void info() {
		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("Customers_User.txt"));

			try {
				int i = 1;
				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					System.out.println(i + ") " + arr[0] + "," + arr[2] + "," + arr[3] + "," + arr[4] + "\n");
					i++;
				}

			} finally {
				buffRead.close();
			}

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}
	}

	
	
	public void updatestate(int num, String louck) {

		boolean success = false;
		int count = 1;
		
		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("Customers_User.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {

				if (count == num) {

					String arr[] = line.split(",");
					arr[4] = louck;

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
	
}
