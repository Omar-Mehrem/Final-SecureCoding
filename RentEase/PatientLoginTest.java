//package finalsecurecoding;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class PatientLoginTest {
//
//	@Test
//	public void ValidLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("ahmad", "Aa87654321");
//		assertTrue(actual);
//
//	}
//
//	@Test
//	public void invalidUsernameLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("Ahmd", "Aa87654321");
//		assertFalse(actual);
//
//	}
//
//	@Test
//	public void invalidPasswordLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("ahmad", "87654321");
//		assertFalse(actual);
//
//	}
//
//	@Test
//	public void invalidUsernameAndPasswordLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("Ahmad", "A87654321");
//		assertFalse(actual);
//
//	}
//
//	@Test
//	public void emptyUsernameLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("", "Aa87654321");
//		assertFalse(actual);
//
//	}
//
//	@Test
//	public void emptyPasswordLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("ahmad", "");
//		assertFalse(actual);
//
//	}
//
//	@Test
//	public void emptyUsernameAndPasswordLoginTest() {
//
//		Patient p = new Patient();
//
//		boolean actual = p.patientLogin("", "");
//		assertFalse(actual);
//
//	}
//
//}
