package ExtentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReport {
    private static ExtentReports extent;
    public static ExtentTest test;

    private ExtentReport() {
    }

    public static ExtentReports initReports() throws IOException {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/Extent-Reports/report.html").viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.EXCEPTION, ViewName.TEST, ViewName.CATEGORY, ViewName.LOG, ViewName.AUTHOR}).apply();
        final File CONF = new File("ExtentConfig.xml");
        reporter.loadXMLConfig(CONF);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        reporter.config().setReportName("Nopcommerce-Regression-HtmlTestReport");
        extent.setSystemInfo("QA Engineer", "Regression");
        return extent;
    }

    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("target/Extent-Reports/report.html").toURI());
    }

    public static void createTest(String testCaseName) {
        test = extent.createTest(testCaseName);
    }
}