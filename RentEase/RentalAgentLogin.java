package finalomarmehrem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RentalAgentLogin {

	public boolean rentalAgentLogin(String name, String password) {
		RentalAgent re = new RentalAgent();
		re.setName(name);
		re.setPassword(password);
		
		BufferedReader buffRead = null;
		try {
			buffRead = new BufferedReader(new FileReader("RentalAgent.txt"));

			try {

				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					String realName = arr[0];
					String realPass = arr[2];

					if (re.getName().equals(realName) && re.getPassword().equals(realPass)) {
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










