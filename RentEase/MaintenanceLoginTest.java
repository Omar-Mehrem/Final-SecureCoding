package finalomarmehrem;

import static org.junit.Assert.*;
import org.junit.Test;

public class MaintenanceLoginTest {

    @Test
    public void validLoginTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("omar3", "12341234Mm");
        assertTrue(actual);
    }

    @Test
    public void invalidPasswordCapsTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("omar3", "12341234MM");
        assertFalse(actual);
    }

    @Test
    public void invalidShortPasswordTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("omar3", "12341234M");
        assertFalse(actual);
    }

    @Test
    public void emptyPasswordTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("omar3", "");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameCaseSensitiveTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("Omar3", "12341234Mm");
        assertFalse(actual);
    }

    @Test
    public void invalidUsernameTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("mm", "12341234Mm");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("", "12341234Mm");
        assertFalse(actual);
    }

    @Test
    public void emptyUsernameAndPasswordTest() {

        MaintenanceLogin ml = new MaintenanceLogin();

        boolean actual = ml.maintenanceLogin("", "");
        assertFalse(actual);
    }
}
