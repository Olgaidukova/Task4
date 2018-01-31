package steps;

import org.junit.Assert;
import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class SendAppSteps {

    @Step("Заполняем элемент ''{0}'' значением ''{1}''")
    public void fillElement(String nameElement, String value){
        new SendAppPage().fillField(nameElement,value);
    }

    @Step("Заполнение полей:")
    public void fillFields(HashMap<String,String> fields){
        fields.forEach((key, value)->fillElement(key,value));
    }


    @Step("Поле ''{0}'' заполнено значением ''{1}''")
    public void checkFillField(String field, String value){
        String actualField = new SendAppPage().getfillField(field);
        Assert.assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actualField, value),actualField.equals(value));
    }

    @Step("Поля заполнены следующими данными:")
    public void checkFillFields(HashMap<String,String> fields){
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("Выбрать пол {0}")
    public void sex(String value){
        new SendAppPage().sex(value);
    }

    @Step("Нажать на оформление")
    public void clickIssue(){
        new SendAppPage().continueClick();
    }
    @Step("Проверка сообщения об ошибке")
    public void checkErrorMessage(String value){new SendAppPage().checkError(value);}

}


