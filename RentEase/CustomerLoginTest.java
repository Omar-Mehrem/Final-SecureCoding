package finalomarmehrem;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerLoginTest {

    @Test
    public void validLoginTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("omar1", "12341234Oo");
        assertTrue(actual);
    }

    @Test
    public void invalidPasswordCapsTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("omar1", "12341234OO");
        assertFalse(actual);
    }

    @Test
    public void invalidShortPasswordTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("omar1", "12341234O");
        assertFalse(actual);
    }

    @Test
    public void emptyPasswordTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("omar1", "");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameCaseSensitiveTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("Omar1", "12341234Oo");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("mm", "12341234Oo");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("", "12341234Oo");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameAndPasswordTest() {

        CusLogin cl = new CusLogin();

        boolean actual = cl.customerLogin("", "");
        assertFalse(actual);
    }
}
