package finalomarmehrem;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdminLoginTest {

    @Test
    public void validLoginTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("omar4", "12341234Aa");
        assertTrue(actual);
    }

    @Test
    public void invalidPasswordCapsTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("omar4", "12341234AA");
        assertFalse(actual);
    }

    @Test
    public void invalidShortPasswordTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("omar4", "12341234A");
        assertFalse(actual);
    }

    @Test
    public void emptyPasswordTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("omar4", "");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameCaseSensitiveTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("Omar4", "12341234Aa");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("mm", "12341234Aa");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("", "12341234Aa");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameAndPasswordTest() {

        AdminLogin al = new AdminLogin();

        boolean actual = al.adminLogin("", "");
        assertFalse(actual);
    }
}
