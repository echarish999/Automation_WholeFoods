package com.wholefood.pageModules;

import com.wholefood.utilities.Utilities;
import org.openqa.selenium.By;

public class Ingredients {
    private static By ingredients=By.xpath("/html/body/main/div[2]/div[2]/div[4]/div/div/div[2]/ul");

    public static String ingredients(){
        return Utilities.getText(ingredients);
    }

}
