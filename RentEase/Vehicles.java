package finalomarmehrem;

public class Vehicles {

	private String model;
	private String licenseNum;
	private float price;
	private String status;

	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}

	public String getLicenseeNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		
		this.licenseNum = licenseNum;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status.equals("Available") || status.equals("Rented") || status.equals("Maintenance")) {
		
			this.status = status;

		} else {
			System.out.println("Invalid input");
		}
	}
}
