package mainUtility;

import org.openqa.selenium.WebElement;

public class Action {

	public static void clickElement(WebElement ele) {

		try {
			ele.click();
		}

		catch (Exception e) {
			System.out.println("error :" + e);
			System.out.println();
		}
	}

}
