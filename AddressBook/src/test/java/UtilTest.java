import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void buildTest() {
        Data.build();
        Assert.assertEquals(31,Data.getProvinces().size());
    }
}
