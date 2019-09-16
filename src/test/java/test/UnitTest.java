package test;

import bean.Result;
import bean.Trimmer;
import main.Main;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;
import utils.DataUtil;


public class UnitTest {

    @BeforeClass
    public static void buildTest() {
        DataUtil.build();
        Assert.assertEquals(31, DataUtil.getProvinces().size());
    }

    @Testable
    public void mainTest() {
        String[] s = new String[]{"1.txt", "2.txt"};
        Main.main(s);
    }

    @Test
    public void case1() {
        String testCase = "1!小张,福建省福州市福清市龙江18150632336街道福山路43号中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "福清市",
                "龙江街道",
                "福山路43号中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case2() {
        String testCase = "2!小张,福建省福州市福清市龙江18150632336街道福山路43号中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "福清市",
                "龙江街道",
                "福山路",
                "43号",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case3() {
        String testCase = "2!小张,18150632336福建省福州市福清市龙江街道福山路43号中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "福清市",
                "龙江街道",
                "福山路",
                "43号",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case4() {
        String testCase = "3!小张,福建省福州市福清市龙江街道福山路43号中银公寓18150632336.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "福清市",
                "龙江街道",
                "福山路",
                "43号",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case5() {
        String testCase = "3!小张,福18150632336建省福清市龙江街道福山路43号中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "",
                "福清市",
                "龙江街道",
                "福山路",
                "43号",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case6() {
        String testCase = "2!小张,福18150632336建省福州市龙江街道福山路43号中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "",
                "龙江街道",
                "福山路",
                "43号",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case7() {
        String testCase = "2!小张,福18150632336建省福州市福清市福山路43号中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "福清市",
                "",
                "福山路",
                "43号",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case9() {
        String testCase = "2!小张,福18150632336建福州福清福山路43号.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "福清市",
                "",
                "福山路",
                "43号",
                ""
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case10() {
        String testCase = "2!小张,福18150632336建福州龙江街道福山路中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "",
                "龙江街道",
                "福山路",
                "",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case11() {
        String testCase = "2!小张,福18150632336建福州龙江街道福山路43号.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "",
                "龙江街道",
                "福山路",
                "43号",
                ""
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case12() {
        String testCase = "2!小张,福18150632336建福州龙江街道福山路中银公寓.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "",
                "龙江街道",
                "福山路",
                "",
                "中银公寓"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case13() {
        String testCase = "2!小张,福18150632336建福州龙江街道福山路.";
        String name = "小张";
        String phone = "18150632336";
        String[] address = new String[]{
                "福建省",
                "福州市",
                "",
                "龙江街道",
                "福山路",
                "",
                ""
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case14() {
        String testCase = "2!甘鞋,甘肃兰州西固区西柳沟街道18629411660上坎街区34号楼.";
        String name = "甘鞋";
        String phone = "18629411660";
        String[] address = new String[]{
                "甘肃省",
                "兰州市",
                "西固区",
                "西柳沟街道",
                "上坎街区",
                "",
                "34号楼"
        };
        resultTest(testCase, name, phone, address);
    }

    @Test
    public void case15() {
        String testCase = "2!甘鞋,甘肃兰州西固区西柳沟街道18629411660什么花园.";
        String name = "甘鞋";
        String phone = "18629411660";
        String[] address = new String[]{
                "甘肃省",
                "兰州市",
                "西固区",
                "西柳沟街道",
                "",
                "",
                "什么花园"
        };
        resultTest(testCase, name, phone, address);
    }

    private void resultTest(String testCase, String expectedName, String expectedPhone, String[] expectedAddress) {
        Result result = new Trimmer(testCase).trim().toResult();
        String message = testCase+System.lineSeparator()+result.toString();
        Assert.assertEquals(message, expectedName, result.getName());
        Assert.assertEquals(message, expectedPhone, result.getPhone());
        Assert.assertArrayEquals(message, expectedAddress, result.getAddress().toArray());
    }
}
