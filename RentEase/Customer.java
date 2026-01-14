package finalomarmehrem;

public class Customer {

	private String name;
	private String password;
	private long phoneNum;
	private long licenseNum;

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

	public long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(long newPhoneNum) {
		int length = String.valueOf(newPhoneNum).length();

		if (length == 10) {
			this.phoneNum = newPhoneNum;

		} else {
			System.out.println("SOMETHING WRONG");

		}
	}

	public long getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(long newLicenseNum) {
		int length = String.valueOf(newLicenseNum).length();

		if (length == 10) {
			this.licenseNum = newLicenseNum;

		} else {
			System.out.println("SOMETHING WRONG");

		}
	}

}


