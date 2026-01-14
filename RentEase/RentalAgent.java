package finalomarmehrem;

public class RentalAgent {

		private String name;
		private String password;
		private int phoneNum;


	
		public String getName() {
			return name;
		}

		public void setName(String name) {

			if (name.length() < 20) {
				this.name = name;

			} else {
				System.out.println("SOMETHING WRONG");
			}

		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			int hash = password.hashCode();
			this.password = String.valueOf(hash);
		}

		public int getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(int phoneNum) {
			int length = String.valueOf(phoneNum).length();

			if (length == 10) {
				this.phoneNum = phoneNum;

			} else {
				System.out.println("SOMETHING WRONG");

			}
		}


	}

	
	
	
	


