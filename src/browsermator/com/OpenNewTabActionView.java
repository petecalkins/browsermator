/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browsermator.com;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;

/**
 *
 * @author pcalkins
 */
public class OpenNewTabActionView extends ActionView {
     OpenNewTabActionView()
   {
    
       
        
       this.JLabelVariable1 = new JLabel("Open New Tab and Switch To It");
theseActionSettings.add(new ActionSettings(JLabelVariable1, 2, 6, 1.0, GridBagConstraints.WEST));
  theseActionSettings.add(new ActionSettings(JButtonOK, 8, 1, 0.0, GridBagConstraints.WEST));
   theseActionSettings.add(new ActionSettings(JButtonDelete, 9, 1, 0.0, GridBagConstraints.WEST));
 
     
  
   }
}
