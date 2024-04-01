package com.qa.doingerp.driver;

import com.codeborne.selenide.WebDriverProvider;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriverProvider implements WebDriverProvider {
    @NotNull
    @Override
    public WebDriver createDriver(@NotNull Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=C:\\Users\\CONSUL~1.ONE\\AppData\\Local\\Temp\\3\\scoped_dir47644_120054629\\Default");
        return new ChromeDriver(options);
    }
}
