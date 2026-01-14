package finalomarmehrem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdminLogin {

	public boolean adminLogin(String name, String password) {
		
		String hash = String.valueOf(password.hashCode());
		
		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("Admin.txt"));

			try {

				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					String realName = arr[0];
					String realPass = arr[1];

					if (name.equals(realName) && hash.equals(realPass)) {
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
