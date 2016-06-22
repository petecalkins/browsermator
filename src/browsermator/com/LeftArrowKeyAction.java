/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browsermator.com;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author pcalkins
 */
public class LeftArrowKeyAction extends Action {
     LeftArrowKeyAction() 
    {
     this.Type = "Left Arrow Key";     
}
     @Override
     public void SetGuts()
     {
         this.Guts = "\n Actions actions = new Actions(driver);\n" +
" \n" +
" actions.sendKeys(Keys.ARROW_LEFT).perform(); ";
     }
  @Override
    public void RunAction(WebDriver driver)
    {
        try
        {
        Actions actions = new Actions(driver);
 
 actions.sendKeys(Keys.ARROW_LEFT).perform(); 
 
     this.Pass = true;
        }
        catch (Exception ex)
        {
            this.Pass = false;
        }
    }  
}
