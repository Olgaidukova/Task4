package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    StrahovanieSteps strahovanieSteps = new  StrahovanieSteps();
    ViborSteps viborSteps = new ViborSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectElement(String name){
        mainSteps.selectElement(name);
    }

    @When("^появился элемент \"(.+)\"$")
    public void waitElement(String name){
        mainSteps.waitElements(name);
    }

    @Then("^выбран элемент \"(.+)\"$")
    public void clickToElement(String name){
        mainSteps.clickToElement(name);
    }

    @When("^заголовок страницы равен \"(.+)\"$")
    public void checkPageTitle(String name){strahovanieSteps.checkPageTitle(name);}

    @Then("^нажатие на оформить онлайн \"(.+)\"$")
    public void clickButton(String name){strahovanieSteps.stepsSendButton(name);}


    @When("^перешли на новую страницу$")
    public void stepToWindow(){
        ArrayList<String> NewTab = new ArrayList<>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(NewTab.get(1));
    }

    @Then("^выбиран тариф \"(.+)\"$")
    public void clickToIssue(String name){viborSteps.stepVibor(name);}


    @When("^заполняются поля:$")
    public void fillFields(DataTable fields){
        fields.asMap(String.class,String.class)
                .forEach((key, value)-> sendAppSteps.fillElement(key, value));
    }
    @When("^выбран пол \"(.+)\"$")
    public void choiceSex(String name){
        sendAppSteps.sex(name);
    }

    @Then("^значения полей равны:$")
    public void checkFillFields(DataTable fields){
        fields.asMap(String.class,String .class)
                .forEach((key,value)-> sendAppSteps.checkFillField(key,value));
    }

    @When("^оформляем$")
    public void finishClickIssue(){sendAppSteps.clickIssue();}

    @Then("^проверяем на наличие ошибки \"(.+)\"$")
    public void checkError(String errorMsg){sendAppSteps.checkErrorMessage(errorMsg);}


}
