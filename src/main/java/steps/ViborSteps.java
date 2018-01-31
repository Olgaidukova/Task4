package steps;

import pages.Vibor;
import ru.yandex.qatools.allure.annotations.Step;


public class ViborSteps {
    @Step("Выбрать минимальную сумму страхования {0}")
    public void stepVibor(String menuItem){
        Vibor choice = new Vibor();
        choice.selectSum(menuItem);
        choice.selectIssueButton();
    }
}