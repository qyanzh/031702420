package bean;

import utils.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trimmer {

    private String name;

    private String phone;

    private final List<String> addressList = new ArrayList<>();

    private String string;

    private String level;

    private Province province;

    private City city;

    private Area area;

    private Street street;

    public Trimmer(String origin) {
        string = origin.substring(0, origin.length() - 1);
    }

    public Result toResult() {
        return new Result(name, phone, addressList);
    }

    public Trimmer trim() {
        trimLevelAndName();
        trimPhone();
        trimProvince();

        if (province != null) {
            addressList.add(province.getName());
            trimCity(province.getCities());
        } else {
            addressList.add("");
        }

        if (city != null) {
            addressList.add(city.getName());
            trimArea(city.getAreas());
        } else {
            addressList.add("");
            if (province != null) {
                List<Area> areas = new ArrayList<>();
                province.getCities().forEach(c -> areas.addAll(c.getAreas()));
                trimArea(areas);
            }
        }

        if (area != null) {
            addressList.add(area.getName());
            trimStreet(area.getStreets());
        } else {
            addressList.add("");
            if (city != null) {
                List<Street> streets = new ArrayList<>();
                city.getAreas().forEach(a -> streets.addAll(a.getStreets()));
                trimStreet(streets);
            }
        }

        if (street != null) {
            addressList.add(street.getName());
        } else {
            addressList.add("");
        }


        switch (level) {
            case "1":
                addressList.add(string);
                break;
            case "2":
                trimDetails();
                break;
            case "3":
                trimDetails();
                break;
            default:
                break;
        }

        return this;
    }


    private void trimLevelAndName() {
        String splitter = "[!,]";
        String[] results = string.split(splitter);
        level = results[0];
        name = results[1];
        string = results[2];
    }

    private void trimPhone() {
        String splitter = "[\\d]{11,}";
        Pattern pattern = Pattern.compile(splitter);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            phone = matcher.group(0);
            string = string.replace(phone, "");
        }
    }

    private void trimProvince() {
        if (string.length() >= 2) {
            String subString = string.substring(0, 2);
            for (Province province : DataUtil.getProvinces()) {
                if (province.getName().contains(subString)) {
                    String name = province.getName();
                    if ("北京".equals(name)
                            || "上海".equals(name)
                            || "天津".equals(name)
                            || "重庆".equals(name)) {
                        string = name + string;
                    }
                    trimSame(string, province.getName());
                    this.province = province;
                    break;
                }
            }
        }
    }


    private void trimCity(List<City> cities) {
        if (string.length() >= 2) {
            String subString = string.substring(0, 2);
            for (City city : cities) {
                if (city.getName().contains(subString)) {
                    trimSame(string, city.getName());
                    this.city = city;
                    break;
                }
            }
        }
    }

    private void trimArea(List<Area> areas) {
        if (string.length() >= 2) {
            String subString = string.substring(0, 2);
            for (Area area : areas) {
                if (area.getName().contains(subString)) {
                    trimSame(string, area.getName());
                    this.area = area;
                    break;
                }
            }
        }
    }

    private void trimStreet(List<Street> streets) {
        if (string.length() >= 2) {
            String subString = string.substring(0, 2);
            for (Street street : streets) {
                if (street.getName().contains(subString)) {
                    trimSame(string, street.getName());
                    this.street = street;
                    break;
                }
            }
        }
    }

    private void trimDetails() {
        String road = "", number = "";
        String splitter = "(.*[区道路街巷里])";
        Pattern pattern = Pattern.compile(splitter);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            road = matcher.group();
            trimSame(string, road);
        }
        splitter = "(\\d+号楼.*)";
        pattern = Pattern.compile(splitter);
        matcher = pattern.matcher(string);
        if(matcher.find()){
            string = matcher.group();
        } else {
            splitter = "(\\d+号)";
            pattern = Pattern.compile(splitter);
            matcher = pattern.matcher(string);
            if(matcher.find()) {
                number = matcher.group();
                trimSame(string, number);
            }
        }
        addressList.add(road);
        addressList.add(number);
        addressList.add(string);
    }

    private void trimSame(String origin, String toTrim) {
        int length = Math.min(origin.length(), toTrim.length());
        int index = length;
        for (int i = 0; i < length; i++) {
            if (origin.charAt(i) != toTrim.charAt(i)) {
                index = i;
                break;
            }
        }
        string = origin.substring(index);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public String getString() {
        return string;
    }

    public String getLevel() {
        return level;
    }

    public Province getProvince() {
        return province;
    }

    public City getCity() {
        return city;
    }

    public Area getArea() {
        return area;
    }

    public Street getStreet() {
        return street;
    }

    @Override
    public String toString() {
        String separator = System.lineSeparator();
        return "level = " + level + separator +
                "string = " + string + separator +
                "name = " + name + separator +
                "phone = " + phone + separator +
                "addressList = " + addressList;
    }
}
