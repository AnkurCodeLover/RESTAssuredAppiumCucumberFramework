package com.appium.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"
        , "html:target/Pixel5/cucumber/report.html"
        , "summary"
//        , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"
        }
        ,features = {"src/test/resources/mobileFeatures"}
        ,glue = {"com.appium.stepdef"}
        ,dryRun=false
        ,monochrome=true
        ,tags = "@test"
        )
public class MyPixel4TestNGRunnerTest extends RunnerBase {
}