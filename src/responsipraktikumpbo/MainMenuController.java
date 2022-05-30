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
public class MainMenuController {
    ViewMainMenu viewmainmenu;

    public MainMenuController(ViewMainMenu vmm) {
        this.viewmainmenu = vmm;
        
        viewmainmenu.btnTambah.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ModelBarang modelbarang = new ModelBarang();
                ViewInputBarang inputbarang= new ViewInputBarang();
                viewmainmenu.setVisible(false);
                InputBarangController inputbarangController=new InputBarangController(inputbarang,modelbarang);
            }
        });
        
        viewmainmenu.btnLihat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) { 
                ViewLihatBarang lihatbarang= new ViewLihatBarang();
                ModelBarang modelbarang = new ModelBarang();
                viewmainmenu.setVisible(false);
                LihatBarangController lihatbarangController =new LihatBarangController(lihatbarang,modelbarang);
            }
        });
    }
    
    
    
}
