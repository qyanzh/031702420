import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {

    @Before
    public void init() {
        Data.build();
    }

    @Test
    public void buildTest() {
        Assert.assertEquals(31, Data.getProvinces().size());
    }

    @Test
    public void trimTest() {
        List<String> testCases = new ArrayList<>();
        testCases.add("2!李四,福建省福州13756899511市鼓楼区鼓西街道湖滨路110号湖滨大厦一层.");
        testCases.add("1!张三,福建福州闽13599622362侯县上街镇福州大学10#111.");
        testCases.add("2!王五,福建省福州市鼓楼18960221533区五一北路123号福州鼓楼医院.");
        testCases.add("3!小美,北京市东15822153326城区交道口东大街1号北京市东城区人民法院.");
        testCases.add("1!小陈,广东省东莞市凤岗13965231525镇凤平路13号.");
        testCases.add("1!张三,福建闽13599622362侯县上街镇福州大学10#111.");
        testCases.forEach(this::trimString);
    }

    private void trimString(String string) {
        System.out.println(new Trimmer(string).trim().toString());
        System.out.println("=========");
    }

}
