package com.wholefood.pageModules;

import com.wholefood.utilities.Utilities;
import org.openqa.selenium.By;


public class Recipe {
    private static By NameOfReciepe=By.xpath("/html/body/main/div[2]/div[1]/div[2]/h1");

    public static String getRecipeName(){
        try {
            String name = Utilities.getText(NameOfReciepe);
            System.out.println(name + "abmple");
            return name;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}
