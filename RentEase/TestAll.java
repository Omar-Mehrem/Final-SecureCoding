package finalomarmehrem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerLoginTest.class, RentalAgentLoginTest.class, MaintenanceLoginTest.class, AdminLoginTest.class })
public class TestAll {

}
