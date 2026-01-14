package finalomarmehrem;

public class MaintenanceStaff {

	private String name;
	private long phoneNum;
	private long licenseNum;
	private String password;

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

	public void setLicenseNum(Long newLicense) {
		int length = String.valueOf(newLicense).length();

		if (length == 10) {
			this.licenseNum = newLicense;

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
	
	

}
