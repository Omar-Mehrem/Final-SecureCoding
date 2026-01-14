package finalomarmehrem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemoveRentalAgent {

	public void info() {

		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("RentalAgent.txt"));

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
	
	
	public void remove(int num, String name) {

		boolean success = false;
		int count = 1;

		try (
				BufferedReader buffRead = new BufferedReader(new FileReader("RentalAgent.txt"));
				BufferedWriter buffWriter = new BufferedWriter(new FileWriter("Temp.txt"))) {

			String line;
			while ((line = buffRead.readLine()) != null) {
				String arr[] = line.split(",");
				
				if (count == num && arr[0].equals(name)) {
					success = true;

				} else {
					
					buffWriter.write(line);
					buffWriter.newLine();
					
				}
				count++;
			}


		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
			
		} finally {

			if (success) {

				File oldFile = new File("RentalAgent.txt");
				File newFile = new File("Temp.txt");

				oldFile.delete();
				newFile.renameTo(oldFile);
				
				System.out.println("Removed successfully");
			}else {
				System.out.println("Not found");
			}

		}

	}
	
	
}
