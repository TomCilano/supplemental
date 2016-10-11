package com.ironyard.Util;

import com.ironyard.data.Staff;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 10/10/16.
 */
public class GsonExample {
    public static void main(String[] args) {

        Staff staff = createDummyObject();

        //1. Convert object to JSON string
        GsonExample gson = new GsonExample();
        String json = gson.toJson(staff);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("D:\\staff.json")) {

            gson.toJson(staff, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Staff createDummyObject() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(35);
        staff.setPosition("Founder");
        staff.setSalary(new BigDecimal("10000"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        skills.add("shell");

        staff.setSkills(skills);

        return staff;
    }
}
