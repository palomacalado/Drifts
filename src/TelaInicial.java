
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class TelaInicial extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton iniciar; 
	JButton instrucao;
	JButton recordes; 
	JButton configuracao;
	JDesktopPane c;
	TelaRecordes record;
	JMenuBar barraMenu = new JMenuBar();
	JMenu informacao = new JMenu("Informações");
	JMenuItem sobre = new JMenuItem("Sobre");
	
	
	public TelaInicial(){
		super("Drifts");
		c = new JDesktopPane(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Image fundo = (new ImageIcon(getClass().getResource("Imagens/inicial.png"))).getImage();   
			
			
	         public void paintComponent(Graphics g){          
	          g.drawImage(fundo,0,0,this); 
	         }
		};
		
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Jogo desenvolvido por Paloma Calado");
				
			}
		});
		informacao.add(sobre);
		barraMenu.add(informacao);
		setJMenuBar(barraMenu);
		barraMenu.setBackground(Color.white);
		
		add(c);
		
		GridBagConstraints cons = new GridBagConstraints();  
     
        GridLayout layout = new GridLayout();
        c.setLayout(layout); 
       //REDIMENCIONAMENTO DOS BOTÕES
        cons.fill = GridBagConstraints.BOTH;  
        cons.gridy = 2;  
        cons.gridx = 0; 
        
        //ESPAÇAMENTO ENTRE OS BOTOES
        cons.insets = new Insets(10,10,0,0);
         
        Font titulo = new Font("serif",Font.BOLD|Font.ITALIC|Font.HANGING_BASELINE,72);
     	JLabel label = new JLabel("Drifts!");
     	label.setFont(titulo);
		
     	
		c.add(label,BorderLayout.NORTH);
		
	
			
        //CRIAÇÃO E DIMENCIONAMENTO DOS BOTOES
		c.setLayout(new GridBagLayout());
		//adicionando o botão iniciar
		iniciar= new JButton("Iniciar");
		c.add(iniciar,cons);
		cons.gridy=3;
		iniciar.addActionListener(this);
		
		//adicionando o botão instruçoes
		instrucao = new JButton("Instrução");
		c.add(instrucao,cons);
		cons.gridy=4;
		instrucao.addActionListener(this);
		
		//adicionando o botão recordes
		recordes =  new JButton("Records");
		c.add(recordes, cons);
		cons.gridy =5;
		recordes.setActionCommand("recordes");
		recordes.addActionListener(this);
		
		//adicionando o botão configurações
		configuracao= new JButton("Configurações");
		c.add(configuracao,cons);
		cons.gridy=6; 	
		configuracao.addActionListener(this);
		
		
		
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
		
	
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
	
       
	public void KeyPressed(KeyEvent tecla){
		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}
	
	public void actionPerformed(ActionEvent e) {			
		if(e.getSource()==iniciar){
				this.dispose();
				new TelaIdentificacao().setVisible(true);				
			}
		
			if(e.getSource()==instrucao){
				this.dispose(); 
				new TelaInstrucao().setVisible(true);
			}
			if(e.getActionCommand()=="recordes"){
				this.dispose();
				try {
					new TelaRecordes().setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getSource()==configuracao){
				this.dispose(); 
				new TelaConfiguracao().setVisible(true);
			}
	}
	
	
}
