/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipraktikumpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
        
        viewinputbarang.btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(viewinputbarang.getTfnama().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Nama Tidak Boleh Kosong");
                }
                else if(viewinputbarang.getTfharga()==0){
                    JOptionPane.showMessageDialog(null, "Harga Tidak Boleh Kosong");
                }
                else if(viewinputbarang.getTfmassa()==0){
                    JOptionPane.showMessageDialog(null, "Massa Tidak Boleh Kosong");
                }
                else if(viewinputbarang.getTfharga()<0){
                    JOptionPane.showMessageDialog(null, "Harga Harus Positif");
                }
                else if(viewinputbarang.getTfmassa()<0){
                    JOptionPane.showMessageDialog(null, "Massa Harus Positif");
                }
                else{
                    modelbarang.insertData(viewinputbarang.getTfnama(), viewinputbarang.getTfmassa(), viewinputbarang.getTfharga());
                }
                
            }
        });
        
        viewinputbarang.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                viewinputbarang.tfnama.setText("");
                viewinputbarang.tfmassa.setText("");
                viewinputbarang.tfharga.setText("");
            }
        });
    }
    
}
