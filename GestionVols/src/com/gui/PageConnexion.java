package com.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Statement;

public class PageConnexion extends JFrame {
/**
 * 
 */
private static final long serialVersionUID = 1L;
//public static Utilisateur utilisateur;
public BaseDonnees b = new BaseDonnees();
public Connection conn;

JPanel panelHaut, panelBas, panelGauche, panelDroite, panelCentre, panelConnexion;

JLabel login = new JLabel("Login");
JLabel pass = new JLabel("Mot de passe");
JPasswordField password = new JPasswordField();
JButton valider = new JButton("Valider");
JButton annuler = new JButton("Annuler");

 JTextField user=new JTextField();
 
    
    public PageConnexion() {

super();

/*Initialisation du JFrame*/
this.setSize (new Dimension (600,400));
//On ne pourra pas agrandir la fenetre intitul�e.
this.setResizable (false);

//valider.addActionListener(new ValiderListener());

/*R�cup�ration du ContentPane*/
Container contenu = this.getContentPane();

/*Cr�ation des JPanel avec leur Layout Manager*/
panelHaut = new JPanel(new GridLayout (1,1));
panelBas = new JPanel(new FlowLayout ());
panelGauche = new JPanel(new GridLayout (1,1));
panelDroite = new JPanel(new GridLayout (1,1));
panelCentre = new JPanel(new GridLayout (0,1));
panelConnexion = new JPanel();

/*Ajout des panneaux au ContentPane*/
    contenu.add(panelHaut, BorderLayout.NORTH);
    contenu.add(panelBas, BorderLayout.SOUTH);
    contenu.add(panelGauche, BorderLayout.EAST);
    contenu.add(panelDroite, BorderLayout.WEST);
    contenu.add(panelCentre, BorderLayout.CENTER);

    /*Ajout du formulaire de connexion � panelCentre*/
    //panelCentre.setBorder(new TitledBorder("Connexion"));
    panelCentre.add(panelConnexion);
    panelCentre.add(login);
    panelCentre.add(user);
    panelCentre.add(pass);
    panelCentre.add(password);          
   
    valider.setPreferredSize(new Dimension(100,50));
    annuler.setPreferredSize(new Dimension(100,50));
    panelBas.add(valider);
       
    panelBas.add(annuler);
    
    /*Ajout du texte de panelConnexion*/
    panelConnexion.add(new JLabel ("Gestion des vols"));
    //setVisible(true);
    
    valider.addActionListener(new ActionListener() {
    		
    	public void actionPerformed(ActionEvent e){
    
	

	//System.out.println(""+user.getText());
	    
	//Objet PreparedStatement
	    Statement statement = null;
	    //Objet ResultSet
	    ResultSet resultat = null;

	        
	b.ConnexionBD();
	conn = b.getConnect();

	//Manipulation
	try {
	//Cr�ation de la requ�te
		statement=(Statement) conn.createStatement();
		
String reqsql="SELECT password FROM utilisateurs WHERE login='"+user.getText()+"'";
	resultat = statement.executeQuery(reqsql);

	if(resultat.next())
	{
	String motDePasse = resultat.getString(1);
	if(motDePasse.equals(password.getText()))
	{
	//JOptionPane.showMessageDialog(null,"Connexion r�ussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
		new Acceuil();
	}
	else {
	JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
	}
	}
	else {
	JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
	}

	//R�cup�ration de la requ�te dans une variable
	//resultat = statement.executeQuery();

	conn.close();
	}
	catch (SQLException ex) {
	System.out.println(ex.getMessage());
	}
	}
    });
    
    
}
    
//    static public Utilisateur init() {
//    	utilisateur=new Utilisateur(user.getText(),mdp.getText());
//       return utilisateur;
//    }

    
    
//    public static void main(String[] args) {
//		new PageConnexion();
//	}
}







