package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) throws SQLException {
        // write your code here

        String host = "localhost";
        String port = "3306";

        Connection conn = DriverManager.getConnection("jdbc:mysql://" + host +":" + port + "/demo", "root", "password");
        System.out.println(conn);
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("select * from credentials where scenario = 'rewardscard'");

        while(rs.next()) {
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver", "/Users/sneha/drivers/chromedriver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://login.salesforce.com/");
            driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
            driver.findElement(By.id("password")).sendKeys(rs.getString("password"));

            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }
    }
}
