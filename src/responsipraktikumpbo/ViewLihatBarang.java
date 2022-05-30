/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsipraktikumpbo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ViewLihatBarang extends JFrame{
    JButton btnKembali = new JButton("Kembali");  
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Id", "Nama", "Massa", "Harga"};

    public ViewLihatBarang() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data ");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600,500);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
              
        add(btnKembali);
        btnKembali.setBounds(20, 420, 90, 20);
    }   
}
