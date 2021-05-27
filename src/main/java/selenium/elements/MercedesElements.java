package selenium.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercedesElements {

	@FindBy(css = "#hatchback-portaledId button")
	protected static
	WebElement btn_hatchback;

	@FindBy(id = "#uc-banner-modal #uc-btn-accept-banner")
	protected static
	WebElement btn_agree_cookies;

}
