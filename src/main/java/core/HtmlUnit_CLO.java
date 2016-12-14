	package core;
	//BEGIN
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.htmlunit.HtmlUnitDriver;
	import com.beust.jcommander.*;
	import java.util.*;

	@Parameters(separators = "=")

	public class HtmlUnit_CLO {
		
	       // String     -u=www.alegro.com
	       @Parameter(names = {"-u", "--url"}, description = "URL")   // required = true)
	       static String url = null; 

	      	// String     -t=alegro.com
			@Parameter(names = {"-t", "—title_expected"}, description = "Title Expected")
			static String title = null; 

			// Help       --help
			@Parameter(names = "--help", help = true, hidden = true)
			static Boolean help = false;
		
		public static void main(String[] args) {

				
//--------------------------------------------------------------------------------------------------//			
            new JCommander(new HtmlUnit_CLO(), args);
            if (help)             {new JCommander(new CLO(), args).usage(); System.exit(0);}
            if (url == null)     {System.err.println("URL is empty");}
            else if (title == null) {System.err.println("Title is empty");}
            else                  {System.out.println("URL " + url + ", Title " + title);}
//--------------------------------------------------------------------------------------------------//
            
			WebDriver driver = new HtmlUnitDriver();   // Version 1.2 :: HtmlUnit

			String text_case_id = "TC-002.01";
			
/*			String url = "http://www.learn2test.net";
			String title_expected = "learn2test.net";*/
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();

			if (title.equals(title_actual)) {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			} else {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
			}
			driver.quit();
		}
	}
	//END
