import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaRecordes extends JFrame implements ActionListener{  
  
	
	/**
	 * 
	 * 
	 **/
	private static final long serialVersionUID = 1L;

	ArrayList<Jogador> records = new ArrayList<>();
	JLabel rotulo = new JLabel("Records");
	JLabel nome = new JLabel("Nomes");
	JLabel pontuacao = new JLabel("Pontuação");
	JTextArea texto;
	File record = new File("records.txt");
	FileReader ler = new FileReader(record);
	JButton voltar = new JButton("Voltar ao menu");
	
	JPanel painel = new JPanel();


     public TelaRecordes() throws IOException { 
    	 super("Drifts");
    	 addKeyListener(new KeyListener() {
 			
 			
 			public void keyTyped(KeyEvent e) {
 							
 			}
 			
 			public void keyReleased(KeyEvent e) {
 							
 			}
 			
 			public void keyPressed(KeyEvent tecla){
 				
 				int codigo = tecla.getKeyCode();
 				
 				if(codigo == KeyEvent.VK_ESCAPE){
 					System.exit(0);
 				}
 				
 		}
    		 
    	 });
    	 
    	
    	
    	painel.add(rotulo);
		
		add(voltar,BorderLayout.SOUTH);
		add(painel,BorderLayout.NORTH);
		voltar.addActionListener(this);

		
		
		lerArquivo();
		add(new JScrollPane(texto));
    	setSize (600 , 400) ;
    	setVisible ( true ) ;
    	setResizable(false);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	 
   	      
     }
     
     public void lerArquivo() throws IOException{
    	 
    	 try(BufferedReader reader = new BufferedReader(ler)){
    		 
    		 String line ;
    		 StringBuffer buffer = new StringBuffer(); 
    		 while(reader.ready()){
    			 line= reader.readLine();
    			 buffer.append(line);
    			 buffer.append("\n");
    			 
    		 }

 			reader.close();
 			texto = new JTextArea(buffer.toString());
 			texto.setEditable(false);
 			
 	    }
    	 
     }

	
	public void actionPerformed(ActionEvent e) {
	
		this.dispose();
		new TelaInicial().setVisible(true);
	
	}
}