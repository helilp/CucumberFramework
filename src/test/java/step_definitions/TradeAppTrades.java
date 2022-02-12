package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTrades {
	
	TradeAppTradesPage tradePage = new TradeAppTradesPage();
	BrowserUtils utils = new BrowserUtils();
	
	String stockSymbol;
	String stockEntryPrice;
	
	@Given("I am on the Trade App log in page")
	public void i_am_on_the_trade_app_log_in_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
	    Assert.assertTrue(tradePage.pleaseSignInText.isDisplayed());
	}
	@When("I enter username {string} password {string}")
	public void i_enter_username_password(String username, String password) {
		tradePage.username.sendKeys(username);
		tradePage.password.sendKeys(password);
	}
	@When("I click on Trade login button")
	public void i_click_on_trade_login_button() {
	    tradePage.signInBtn.click();
	}
	@Then("I should be on Trade homepage")
	public void i_should_be_on_trade_homepage() {
	  Assert.assertTrue(tradePage.tradeIconImage.isDisplayed());
	  Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
	}
	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
		tradePage.addTradeBtn.click();
	}
	@Then("I should be on Save Trade page")
	public void i_should_be_on_save_trade_page() {
	    Assert.assertTrue(tradePage.saveTradeText.isDisplayed());
	}
	@When("I select {string} and I enter symbol {string} entryDate {string} entryPrice {string} exitDate {string} exitPrice {string}")
	public void i_select_and_i_enter_symbol_entry_date_entry_price_exit_date_exit_price(String buyOrsell, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		stockSymbol = symbol;
		stockEntryPrice = entryPrice;
		// select from the dropdown
		utils.selectByVisibleText(tradePage.buyOrSellDropdown, buyOrsell);
		
		tradePage.stockSymbol.sendKeys(symbol);
		tradePage.openDate.sendKeys(entryDate);
		tradePage.stockEntryPrice.sendKeys(entryPrice);
		tradePage.closeDate.sendKeys(exitDate);
		tradePage.stockExitPrice.sendKeys(exitPrice);
	}
	@When("I click Save button")
	public void i_click_save_button() {
	    tradePage.saveBtn.click();
	}
	@Then("The trade is displayed on the trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
		
		for (WebElement singleSymbol : tradePage.stockSymbols) {
			if (singleSymbol.getText().equals(stockSymbol)) {
				Assert.assertEquals(singleSymbol.getText(), stockSymbol);;
			}
		}
		
	}

}
