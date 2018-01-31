package steps;

import pages.Strahovanie;
import ru.yandex.qatools.allure.annotations.Step;

import static junit.framework.TestCase.assertTrue;


public class StrahovanieSteps {
    @Step("Выполнено нажатие на Оформить онлайн")
    public void stepsSendButton(String name){
        new Strahovanie().button.click();
    }

    @Step("Проверка наличия на странице заголовка – Страхование путешественников")
    public void checkPageTitle(String titleElement){
        String actualTitle = new Strahovanie().title.getText();
        assertTrue(String.format("Заголовок на странице [%s]. Ожидалось - [%s]", actualTitle, titleElement),actualTitle.equals(titleElement));
    }
}