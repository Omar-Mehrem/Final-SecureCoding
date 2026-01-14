package finalomarmehrem;

public class PasswordPolicy {

	private int minLength;
	private boolean requireUppercase;
	private boolean requireLowercase;
	private boolean requireDigit;

	public PasswordPolicy() {
		this.minLength = 8;
		this.requireUppercase = true;
		this.requireLowercase = true;
		this.requireDigit = true;
	}


	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}


	public void setRequireUppercase(boolean requireUppercase) {
		this.requireUppercase = requireUppercase;
	}


	public void setRequireLowercase(boolean requireLowercase) {
		this.requireLowercase = requireLowercase;
	}


	public void setRequireDigit(boolean requireDigit) {
		this.requireDigit = requireDigit;
	}


	public int getMinLength() {
		return minLength;
	}

	public boolean isRequireUppercase() {
		return requireUppercase;
	}

	public boolean isRequireLowercase() {
		return requireLowercase;
	}

	public boolean isRequireDigit() {
		return requireDigit;
	}

	public static boolean isValidPassword(String password, PasswordPolicy policy) {

	    if (password == null || password.length() < policy.getMinLength()) {
	        return false;
	    }

	    boolean hasUpper = false;
	    boolean hasLower = false;
	    boolean hasDigit = false;

	    for (char c : password.toCharArray()) {
	        if (Character.isUpperCase(c)) {hasUpper = true;}
	        else if (Character.isLowerCase(c)) { hasLower = true;}
	        else if (Character.isDigit(c)) {hasDigit = true;}
	    }

	    if (policy.isRequireUppercase() && !hasUpper) {
	    	
	        System.out.println("Password must contain at least one uppercase letter"); 
	    	return false;
	    }
	    if (policy.isRequireLowercase() && !hasLower) {
	    	
	    	System.out.println("Password must contain at least one lowercase letter");
	    	return false;
	    }
	    if (policy.isRequireDigit() && !hasDigit) {
	    	
	    	System.out.println("Password must contain at least one digit");
	    	return false;
	    }

	    return true;
	}


}
