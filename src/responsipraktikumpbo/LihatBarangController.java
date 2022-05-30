/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipraktikumpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author ACER
 */
public class LihatBarangController {
    ViewLihatBarang vlb;
    ModelBarang mb;

    public LihatBarangController(ViewLihatBarang vlb, ModelBarang mb) {
        this.vlb = vlb;
        this.mb = mb;
        if (mb.getBanyakData()!=0) {
            String dataBarang[][] = mb.readBarang();
            vlb.tabel.setModel((new JTable(dataBarang, vlb.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        vlb.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewMainMenu vmm=new ViewMainMenu();
                vlb.setVisible(false);
                MainMenuController mmc=new MainMenuController(vmm);
            }
        });
        
        vlb.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = vlb.tabel.getSelectedRow();                

                String dataterpilih = vlb.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);
                ViewBanyakBarang vbb=new ViewBanyakBarang();
                vlb.setVisible(false);
                BanyakBarangController bbc=new BanyakBarangController(vbb,dataterpilih,mb);
                
                                                                            
            }
        }
        );
    }
    
}
