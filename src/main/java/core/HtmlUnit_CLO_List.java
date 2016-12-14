package core;
//BEGIN
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.beust.jcommander.*;
import java.util.*;

@Parameters(separators = "=")

public class HtmlUnit_CLO_List {
		
// List      -l="http://www.alegro.com|www.alegro.com", "http://www.alegro.com|blah blah"
@Parameter(names = {"-l", "--list"}, variableArity = true, description = "My List separated by '='")
static List<String> list = new ArrayList<String>();
	       
@Parameter(names = {"-h","--help"}, help = true, hidden = true)
static Boolean help = false;

/* ========================================== */		
	public static void main(String[] args) {
/* ========================================== */			
new JCommander(new HtmlUnit_CLO_List(), args);
if (help)             {new JCommander(new HtmlUnit_CLO_List(), args).usage(); System.exit(0);}
if (list.size() == 0) {System.err.println("List is empty");}
else {
            	for (int i = 0; i < list.size(); i++) {
        			WebDriver driver = new HtmlUnitDriver();   // Version 1.2 :: HtmlUnit
        			
        			String test_case_id = "TC-001.0"+(i+1);
        			String param[] = list.get(i).split("\\|");
        			String url = param[0];
        			String title_expected = param[1];
     	
		 			driver.get(url);
					//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					String title_actual = driver.getTitle();           
            
					if (title_expected.equals(title_actual)) 
					{
						//System.out.println();
						System.out.println("Test Case ID: \t\t" + test_case_id);
						System.out.println("URL: \t\t\t" + url);
						System.out.println("Title Expected: \t" + title_expected);
						System.out.println("Title Actual: \t\t" + title_actual);
						System.out.println("Test Case Result: \t" + "PASSED");
						//System.out.println();
					} else {
						//System.out.println();
						System.out.println("Test Case ID: \t\t" + test_case_id);
						System.out.println("URL: \t\t\t" + url);
						System.out.println("Title Expected: \t" + title_expected);
						System.out.println("Title Actual: \t\t" + title_actual);
						System.out.println("Test Case Result: \t" + "FAILED");
						//System.out.println();   
							}
					driver.quit();
					System.out.println("===================================================================");
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	}}}
	//END
	
