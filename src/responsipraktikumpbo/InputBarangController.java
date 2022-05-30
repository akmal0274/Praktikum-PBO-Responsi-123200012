/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipraktikumpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ACER
 */
public class InputBarangController {
    ViewInputBarang viewinputbarang;
    ModelBarang modelbarang;

    public InputBarangController(ViewInputBarang viewinputbarang, ModelBarang modelbarang) {
        this.viewinputbarang = viewinputbarang;
        this.modelbarang = modelbarang;
        
        viewinputbarang.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewMainMenu viewmainmenu =new ViewMainMenu();
                viewinputbarang.setVisible(false);
                MainMenuController Start=new MainMenuController(viewmainmenu);
            }
        });
    }
    
}
