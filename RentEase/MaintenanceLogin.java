package finalomarmehrem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaintenanceLogin {

	public boolean maintenanceLogin(String name, String password) {
		BufferedReader buffRead = null;
		
		MaintenanceStaff main  = new MaintenanceStaff();
		main.setName(name);
		main.setPassword(password);
		try {
			buffRead = new BufferedReader(new FileReader("Maintenance_Staff.txt"));


			try {

				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					String realName = arr[0];
					String realPass = arr[3];

					if (main.getName().equals(realName) && main.getPassword().equals(realPass)) {
						return true;
					}
				}

			} finally {
				buffRead.close();
			}

		} catch (IOException e) {
			System.out.println("SOMETHING WRONG");
		}
		return false;

	}

}
