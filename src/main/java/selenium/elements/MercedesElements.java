package selenium.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercedesElements {

	@FindBy(css = "user_id")
	protected static
	WebElement btn_hatchback;

	@FindBy(id = "password")
	protected static
	WebElement btn_agree_cookies;

}
