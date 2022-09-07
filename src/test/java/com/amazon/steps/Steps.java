package com.amazon.steps;

import com.amazon.methods.Methods;
import com.thoughtworks.gauge.Step;
import com.amazon.driver.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;


public class Steps extends BaseTest {
    public Methods methods;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public Steps() {
        methods = new Methods();
    }

    @Step("<second> wait")
    public void waitBySeconds(long second) throws RuntimeException {
        methods.waitBySeconds(second);
    }

    @Step("<key> click")
    public void click(String str) {
        methods.click(str);
    }

    @Step("<key> sendKeys <send>")
    public void sendKey(String str, String key) {
        methods.sendKeys(str, key);
    }


    @Step("<key> hover")
    public void hover(String str) {
        methods.hoverToElement(str);
    }

    @Step("<key> pick randomly and add favorites")
    public void selectRandomItem(String str) {
        List<String> hrefs = methods.getHrefs(str);
        methods.randPickAndAddFav(hrefs,"addFavoritesList","closeTheFrame");
    }

    @Step("find the product that has maximum price")
    public void selectHighPrice() {
        List<WebElement> itemsWithPrice = methods.findElements("productPrices");
        List<WebElement> elements = methods.findElements("productPictures");
        int index = methods.findMaxPrice(itemsWithPrice);
        methods.click(elements.get(index));
        methods.waitBySeconds(2);
    }

    @Step("<key> sendKeys <key> with js")
    public void sendKeysWithJs(String str, String text) {
        js.executeScript("arguments[0].value='" + text + "';", methods.findElement(str));
    }

    @Step("<key> click if is visible")
    public void clickByIdIfIsVisible(String str) {
        methods.isVisibleAndClick(str);
    }

    @Step("<index> change frame with index")
    public void switchFrame(int index) {
        methods.switchFrameWithIndex(0);
    }

    @Step("parent frame")
    public void parentFrame() {
        methods.switchParentFrame();
    }


}