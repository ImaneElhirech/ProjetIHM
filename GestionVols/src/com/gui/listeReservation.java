package com.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.PreparedStatement;

public class listeReservation extends JFrame {
	
	 private JTable jTable1;
	 private DefaultTableModel dtm;
	 private BaseDonnees b = new BaseDonnees();
	 private Connection conn;
	 private JLabel label1;
	 
	 
	public listeReservation() {
		
		setTitle("Reservation"); 
		setSize(500,300); 
		setLocationRelativeTo(null); 
		setResizable(false); 
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel panel = new JPanel(new GridLayout (1,1));
		JPanel panel2 = new JPanel(new GridLayout (0,1));
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.white);
		
		panel2.setLayout(new FlowLayout());
		panel2.setBackground(Color.white);
		
		Container contenu = this.getContentPane();
		contenu.add(panel, BorderLayout.CENTER);
		contenu.add(panel2, BorderLayout.NORTH);
		
		
		
		
		label1=new JLabel("Les Reservation Effectuees" );
		
		 
		Font font = new Font("Comic Sans MS",Font.BOLD,20);
		label1.setFont(font);
		
	jTable1 = new JTable();
    dtm = new DefaultTableModel(new String[] { "IdReservation","Date de D�part","Date d'arriv�" }, 0);
    jTable1.setModel(dtm);
    
    panel.add(jTable1);
    
    panel2.add(label1);
    
    b.ConnexionBD();
	conn = b.getConnect();
	
    String query1 = "SELECT * FROM Resrvation";
    try{
        PreparedStatement stm = (PreparedStatement) conn.prepareStatement(query1);

        ResultSet rs = stm.executeQuery(query1);

        while (rs.next()) {

        	dtm.addRow(new Object[]{ rs.getInt("IdRes"), rs.getDate("DateDepart"),rs.getDate("DateArrivee")});

        }
        jTable1.setBackground(Color.magenta);
        jTable1.setBorder(BorderFactory.createLineBorder(Color.black));
        

        rs.close();
    }
    catch(SQLException e) {
        e.printStackTrace();
    }
    
    
    setVisible(true);
   
	}
	
	
}
