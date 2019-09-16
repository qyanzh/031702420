import main.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.DataUtil;
import utils.Trimmer;

import java.util.ArrayList;
import java.util.List;

public class UnitTest {

    @Before
    public void init() {
        DataUtil.build();
    }

    @Test
    public void buildTest() {
        Assert.assertEquals(31, DataUtil.getProvinces().size());
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
        testCases.add("1!小明,内蒙古锡13599622362林郭勒盟二连浩特市.");
        testCases.add("1!梁钓睡,江西省九江市修水县208县道征村乡熏衣村村民委13510061140员会.");
        testCases.add("1!陈敲,北京市顺义区石园街道顺康路1号港馨家18770445535园19号楼.");
        testCases.add("1!梁钓睡,江西省九江市修水县208县道征村乡熏衣村村13510061140民居委会");
        testCases.add("1!梁钓睡,福建省九江市修水县征村乡熏衣村村13510061140民居委会");
        testCases.forEach(this::trimString);
    }

    private void trimString(String string) {
        System.out.println(new Trimmer(string).trim().toResult());
    }


    @Test
    public void mainTest(){
        String[] s = new String[]{"1.txt","2.txt"};
        Main.main(s);
    }

}
