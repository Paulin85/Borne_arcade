package premier;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame{
		
	    private JTextField textField;
	    public Fenetre() {
	    	initFenetre();
	    }
    
	    
	    private void initFenetre() {
	    	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    	setBounds(100, 100, 500, 500);
	    	
	    	
	    	JPanel monPanel = new JPanel();
	    	setContentPane(monPanel);
	        //definition du layout
	        setLayout(null);

	        //creation d'un label
	        JLabel monLabel1 = new JLabel();
	        monLabel1.setText("Pseudo Joueur 1");
	        //positionner le label
	        monLabel1.setBounds(20, 20, 100, 20);
	        monPanel.add(monLabel1);
	        
	        //creation d'un label
	        JLabel monLabel2 = new JLabel();
	        monLabel2.setText("Pseudo Joueur 2");
	        //positionner le label
	        monLabel2.setBounds(300, 20, 100, 20);
	        monPanel.add(monLabel2);
	        
	        JTextField monTexte = new JTextField();
	        monTexte.setBounds(20, 40, 100, 20);
	        
	        JTextField monTexte2 = new JTextField();
	        monTexte2.setBounds(300, 40, 100, 20);
	        
	        JButton btn1 = new JButton("OK");
	        btn1.setBounds(160, 100, 100, 20);
	        monPanel.add(btn1);
	        
	        monPanel.add(monTexte);
	        monPanel.add(monTexte2);
	        
	        btn1.addActionListener(new ActionListener() {
	        	@Override
	            public void actionPerformed(ActionEvent e) {
	        		Joueur p = new Joueur();
	        		Joueur2 p2 = new Joueur2();

	                p.setPseudo_joueur(monTexte.getText());
	                
	                p2.setPseudo_joueur(monTexte2.getText());
	                
	                dispose();
	                

	        	}
	        });
	    

	                
	        setVisible(true);
	    }
	    
    public int getID() {
        return 6;
    }
    

 
    public JTextField getTextField(){
        return textField;
    }
 
   
    
}