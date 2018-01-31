package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class Vibor {
    @FindBy(xpath = "//h3 [text()='Выберите сумму страховой защиты']/parent::section")
    public WebElement programma;

    @FindBy(xpath = "//span [contains(text(),'Оформить')]")
    public WebElement issueButton;



    public Vibor(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(),10, 1000);
        wait.until(ExpectedConditions.visibilityOf(programma));
        JavascriptExecutor js =(JavascriptExecutor)BaseSteps.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",programma);
        wait.until(ExpectedConditions.visibilityOf(issueButton));

    }

    public void selectSum(String menuItem){
        programma.findElement(By.xpath(".//div[text()='"+ menuItem +"']")).click();

    }

    public void selectIssueButton(){
        issueButton.click();
    }


}
