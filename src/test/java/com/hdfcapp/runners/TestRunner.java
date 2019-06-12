package com.hdfcapp.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/features/hdfclogin.feature",monochrome=true,glue="com.hdfc.mapper")
public class TestRunner extends AbstractTestNGCucumberTests{

}
