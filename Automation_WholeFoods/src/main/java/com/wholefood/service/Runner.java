package com.wholefood.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wholefood.dataProvider.UrlDataProvider;
import com.wholefood.pageModules.Ingredients;
import com.wholefood.pageModules.MacroNutrition;
import com.wholefood.pageModules.Recipe;
import com.wholefood.pojo.Item;
import com.wholefood.pojo.MacroNutrients;
import com.wholefood.pojo.WholeFoods;
import com.wholefood.utilities.Utilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Runner {
    static Item item=null;
    static List<Item> items=new LinkedList<Item>();

    /*
        right click and run test methos which will invoke the end to end test by reading url from input.txt
     */

    @Test
    public void test() throws IOException {
        openUrl(UrlDataProvider.fileRead());
        item=new Item();
        recipeName();
        ingredients();
        macroNutrition();
        dataMapping();

    }

/*
*   run method two where data provider is defined instead of excel or text file.
* this will invoke test cases as per the number of test cases in that data provider
*
*/

    @Test(dataProvider = "url")
    public void openUrl(String url){
        Utilities.initializeChromeDriver(url);
    }


    @Test(groups={"recipeName"})
    public static void recipeName(){
        String recipeName=Recipe.getRecipeName();
        System.out.println("bkb"+recipeName);
        item.setName(recipeName);
    }

    @Test(groups={"ingredients"})
    public static void ingredients(){
        String ingredient[]= Ingredients.ingredients().split("\n");
        List<String> ingredientList = new LinkedList<String>();
        for(int i=0;i<ingredient.length;i++)
            ingredientList.add(ingredient[i]);

        item.setIngredieidnts(ingredientList);


    }

    @Test(groups={"macroNutrition"})
    public static void macroNutrition(){
        String macroNurtition[]=MacroNutrition.macroNutrients().split(",");
        int carbs=0,fat=0,protien=0;
        for(int i=0;i<macroNurtition.length;i++)
        {
            System.out.println("macroNurtition[i]"+macroNurtition[i]);

            if(macroNurtition[i].contains("calories")){
                 carbs=extractNumber(macroNurtition[i]);
            }
            if(macroNurtition[i].contains("g saturated fat")){
                fat=extractNumber(macroNurtition[i]);
            }
            if(macroNurtition[i].contains("g protein")){
                protien=extractNumber(macroNurtition[i]);
            }
        }
        MacroNutrients macroNutrients=new MacroNutrients();
        macroNutrients.setCarb(carbs);
        macroNutrients.setFat(fat);
        macroNutrients.setProtein(protien);
        item.setMacroNutrients(macroNutrients);


    }



    public static void dataMapping() throws JsonProcessingException {

        items.add(item);
        WholeFoods obj1=new WholeFoods();
        obj1.setItems(items);

        ObjectMapper objectMapper=new ObjectMapper();
        String jsonResponse=objectMapper.writeValueAsString(obj1);
        System.out.println(jsonResponse);

        try {
            FileWriter file = new FileWriter("src/main/resources/Output/output.json");
            file.write(jsonResponse);
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @AfterClass
    public void quit(){

        Utilities.quitDriver();
    }
/*
we are extracting only numbers from this string
 */

    public static int extractNumber(String str) {

        Pattern pattern = Pattern.compile("(\\d+)");

        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return Integer.parseInt(matcher.group(1));
        }

        return -1;
    }
    /*
        Data provider is same like text file or excel file.
        We can store all data and pass it as a test case to method
     */

    @DataProvider(name = "url")
    public Object[][] getData() {
        return new Object[][]{{ "https://www.wholefoodsmarket.com/recipes/lentil-and-quinoa-salad-cashews"},
                { "https://www.wholefoodsmarket.com/recipes/classic-french-toast"},
        };
    }


}
