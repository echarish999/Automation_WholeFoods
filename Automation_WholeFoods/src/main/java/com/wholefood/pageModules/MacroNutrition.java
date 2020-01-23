package com.wholefood.pageModules;

import com.wholefood.utilities.Utilities;
import org.openqa.selenium.By;

public class MacroNutrition {
    private static By macroNutrients=By.xpath("/html/body/main/div[2]/div[2]/div[6]/div[2]");

    public static String macroNutrients(){
        return Utilities.getText(macroNutrients);
    }

}
