package finalomarmehrem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CusLogin {

	public boolean customerLogin(String name, String password) {
		BufferedReader buffRead = null;
		
		Customer cus = new Customer();
		cus.setName(name);
		cus.setPassword(password);
		try {
			buffRead = new BufferedReader(new FileReader("Customers_User.txt"));

			try {

				String line;
				while ((line = buffRead.readLine()) != null) {
					String arr[] = line.split(",");

					String realName = arr[0];
					String realPass = arr[1];
					String locked = arr[4];

					if (cus.getName().equals(realName) && cus.getPassword().equals(realPass) && "No".equals(locked)) {
						return true;
					}
				}

			} finally {
				buffRead.close();
			}

		} catch (IOException e) {
			System.out.println("something wrong");
		}
		return false;

	}

}
