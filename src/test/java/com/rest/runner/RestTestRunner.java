package com.rest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"
                , "html:target/RestAPI/cucumber/report.html"
                , "summary"
//        , "me.jvt.cucumber.report.PrettyReports:target/Pixel3/cucumber-html-reports"
        }
        ,features = {"src/test/resources/restFeatures"}
        ,glue = {"com.rest.stepdef"}
        ,dryRun=false
        ,monochrome=true
        //,tags = "@test"
)
public class RestTestRunner extends AbstractTestNGCucumberTests {
}
