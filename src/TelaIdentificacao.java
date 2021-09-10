import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaIdentificacao extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField nome  = new SoLetra(10);
	JButton guardar = new JButton("Jogar Agora!");
	JButton voltar = new JButton("Voltar");
	JDesktopPane c;
	static String jogador;
		
		public TelaIdentificacao(){
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
			
			JLabel label = new JLabel("Nome do jogador:");
			add(c);	
			nome.setFont(new Font("Serif",Font.PLAIN,30));
			c.add(label);
			label.setBounds(240,100,300,25);
			
			c.add(nome);
			nome.setBounds(150,150,300,50); 
			nome.setText("");
			c.add(guardar);
			guardar.setBounds(200,205,200,25); 
			guardar.addActionListener(this);
			c.add(voltar);
			voltar.setBounds(200,235,200,25);
			voltar.addActionListener(this);
			
			
			
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
			

			setResizable(false);
			setSize(600,400);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		}

			
		public void actionPerformed(ActionEvent e) {
		
			if(e.getSource()==guardar){
				
				if(nome.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null,"Digite seu nome, por favor","ERROR!",0);
				}else{
					jogador=nome.getText();
					this.dispose();
					new TelaJogo().setVisible(true);
				}
				
			}
			
			if(e.getSource()==voltar){
				this.dispose(); 
				new TelaInicial().setVisible(true);
				
			}
		
			
		}
				
}
