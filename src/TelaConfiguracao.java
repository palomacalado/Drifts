import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TelaConfiguracao extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font texto = new Font("serif",Font.BOLD|Font.ITALIC|Font.HANGING_BASELINE,20);
	JCheckBox sim = new JCheckBox("sim");
	JCheckBox nao = new JCheckBox("não");
	JButton voltar = new JButton("voltar");
	JDesktopPane c;
		
	public TelaConfiguracao(){
		super("Drift");
		
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
		add(c);
		c.setLayout(null);
		
		JLabel label = new JLabel("Ativar som?");
		label.setFont(texto);
		label.setBounds(200,100,400,25);
		
		sim.addItemListener(new CheckListener());
		nao.addItemListener(new CheckListener());
		
		c.add(label);
		c.add(sim);
		c.add(nao);
		c.add(voltar);

		voltar.addActionListener(this);
		sim.setBackground(Color.white);
		nao.setBackground(Color.white);
		
		sim.setBounds(250,150,55,25);
		nao.setBounds(250,205,55,25);
		voltar.setBounds(230,300,100,25);
		
		setResizable(false);
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
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
		
	}
	class CheckListener implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
			if(sim.isSelected()){
				TelaJogo.ativa=true;
				
			}
			if(nao.isSelected()){
				TelaJogo.ativa = false;
			}
			if(sim.isSelected() && nao.isSelected()){
				JOptionPane.showMessageDialog(null,"Opção Inválida!");
			}
			
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new TelaInicial().setVisible(true);
		
	}
	

}
