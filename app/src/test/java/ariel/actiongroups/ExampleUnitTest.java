package ariel.actiongroups;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.mockito.Mockito;

import ariel.actiongroups.main.common.users.models.User;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Rule
    public TestName rulesTest = new TestName();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isCorrect2() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void mockUser(){
        User user = Mockito.mock(User.class);
        Mockito.when(user.getObjectId()).thenReturn("333");
        Assert.assertEquals("333", user.getObjectId());
    }
}