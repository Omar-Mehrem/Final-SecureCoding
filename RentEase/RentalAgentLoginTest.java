package finalomarmehrem;

import static org.junit.Assert.*;
import org.junit.Test;

public class RentalAgentLoginTest {

    @Test
    public void validLoginTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("omar2", "12341234Rr");
        assertTrue(actual);
    }

    @Test
    public void invalidPasswordCapsTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("omar2", "12341234RR");
        assertFalse(actual);
    }

    @Test
    public void invalidShortPasswordTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("omar2", "12341234R");
        assertFalse(actual);
    }

    @Test
    public void emptyPasswordTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("omar2", "");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameCaseSensitiveTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("Omar2", "12341234Rr");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("mm", "12341234Rr");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("", "12341234Rr");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameAndPasswordTest() {

        RentalAgentLogin ra = new RentalAgentLogin();

        boolean actual = ra.rentalAgentLogin("", "");
        assertFalse(actual);
    }
}
