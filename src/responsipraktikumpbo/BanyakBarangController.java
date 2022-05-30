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
public class BanyakBarangController {
    ViewBanyakBarang vbb;
    String id;
    ModelBarang mb;

    public BanyakBarangController(ViewBanyakBarang vbb, String id, ModelBarang mb) {
        this.vbb = vbb;
        this.id = id;
        this.mb = mb;
        String detailBarang[]=mb.detailBarang(id);
                
                vbb.l2Nama.setText(detailBarang[1]);
                vbb.l2Massa.setText(detailBarang[2]);
                vbb.l2Harga.setText(detailBarang[3]); 
                
        vbb.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewLihatBarang vlb=new ViewLihatBarang();
                vbb.setVisible(false);
                LihatBarangController Start=new LihatBarangController(vlb, mb);
            }
        });
        vbb.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus data Karyawan dengan ID " + id + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    mb.deleteData(id);    
                    ViewLihatBarang vlb=new ViewLihatBarang();
                    vbb.setVisible(false);
                    LihatBarangController lbc=new LihatBarangController(vlb, mb);
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
        vbb.btnTotHarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewDetailHarga detailTotal=new ViewDetailHarga();
                vbb.setVisible(false);
                detailTotal.l2Nama.setText(detailBarang[1]);
                detailTotal.l2Massa.setText(detailBarang[2]);
                detailTotal.l2Harga.setText(detailBarang[3]);
                double harga =Double.parseDouble(detailBarang[3]);
                String banyak = vbb.getTftot().getText();
                double temp=Double.parseDouble(banyak);
                if(temp<1){
                    JOptionPane.showMessageDialog(null, "Harus Bilangan Positif");
                }
                else if(temp>=1 && temp<12){
                    double total = temp*harga;
                    String hasil=Double.toString(total);
                    detailTotal.l2tot.setText(hasil); 
                }
                else if(temp>=12 && temp<20){
                    double total = (temp*harga)*0.95;
                    String hasil=Double.toString(total);
                    detailTotal.l2tot.setText(hasil); 
                }
                else if(temp>=20 && temp<144){
                    double total = (temp*harga)*0.9;
                    String hasil=Double.toString(total);
                    detailTotal.l2tot.setText(hasil); 
                }
                else{
                    double total = (temp*harga)*0.75;
                    String hasil=Double.toString(total);
                    detailTotal.l2tot.setText(hasil); 
                }
                
                detailTotal.btnKembali.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {                               
                        ViewLihatBarang vlb=new ViewLihatBarang();
                        vbb.setVisible(false);
                        LihatBarangController Start=new LihatBarangController(vlb, mb);
                    }
                });
            }
        });
        vbb.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                               
                ViewInputBarang vib=new ViewInputBarang();
                vbb.setVisible(false);
                EditController editController=new EditController(vib,mb,id);
            }
        });
    }
    
    
}
