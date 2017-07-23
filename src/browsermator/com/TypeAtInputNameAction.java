
package browsermator.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TypeAtInputNameAction extends Action 
{
   
     TypeAtInputNameAction (String TargetFieldID, String ToType, Boolean BoolVal1)
    {
        this.Type = "Type at Input Name";
        
        this.Variable1 = TargetFieldID;
        this.Variable2 = ToType;
        this.BoolVal1 = BoolVal1;
    }
     @Override
     public void SetGuts()
     {
    this.Guts = "\ntry\n" +
"{\n" +
"WebElement element = driver.findElement(By.name(\""+this.Variable1+"\"));    \n" +
"element.sendKeys(\""+this.Variable2+"\");";
  if (this.BoolVal1.equals(true))
{
   this.Guts+="element.sendKeys(Keys.RETURN);";
} 
  this.Guts+="this.Pass = true;\n" +
"}\n" +
"catch (NoSuchElementException e)\n" +
" {\n" +
"  this.Pass = false;\n" +
"  \n" +
" }";
     }
    @Override
    public void RunAction(WebDriver driver)
    {

try
{
WebElement element = driver.findElement(By.name(this.Variable1));   
char[] keys_to_type = this.Variable2.toCharArray();
for(int i=0;i<keys_to_type.length;i++){
    String sendkey = String.valueOf(keys_to_type[i]);
  try
  {
Thread.sleep((long)(Math.random() * 200));
  }
  catch (Exception ex)
  {
      System.out.println ("Exception when sleeping random: " + ex.toString());
  }
          
element.sendKeys(sendkey);
}

if (this.BoolVal1.equals(true))
{
      try
  {
Thread.sleep((long)(Math.random() * 200));
  }
  catch (Exception ex)
  {
      System.out.println ("Exception when sleeping random: " + ex.toString());
  }
    element.sendKeys(Keys.RETURN);
}
this.Pass = true;
}
catch (NoSuchElementException e)
 {
  this.Pass = false;
  
 }
    }
}
