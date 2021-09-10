import java.awt.FlowLayout;
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
import javax.swing.SwingConstants;


public class TelaInstrucao extends JFrame  implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jogar;
	JButton voltar;
	JDesktopPane c ;

	public TelaInstrucao(){
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
		add(c);
		 c.setLayout(new FlowLayout(FlowLayout.CENTER));
        Font titulo = new Font("serif",Font.BOLD|Font.ITALIC|Font.HANGING_BASELINE,16);
      	JLabel label = new JLabel("Instruções");
		label.setFont(titulo);
		label.setSize(200,200);
	   
		
		
		label.setText("<HTML><HEAD><TITLE><H1  ALIGN=CENTER> Como Jogar</H1> </TITLE></HEAD><BODY><H3>"+
				" <P>Mova a bolha vermelha com o mouse, o objetivo do jogo é <BR>acumular bolhas verdes sem tocar nas bolas roxas <BR>"+
				" dentro do tempo estipulado de dois minutos. <BR>"+
				"<BR>Para converter as bolhas verdes em pontos, basta tocar,<BR> nas bolhas azuis e é necessário no mínimo 3<BR> bolhas"+
				" verdes para ganhar ponto. <BR>Acumule mais e ganhe pontos extras!<BR><BR><BR></H3></BODY></HTML>");
		label.setVerticalTextPosition(SwingConstants.HORIZONTAL);
		c.add(label);
			
	    
        
         //CRIAÇÃO E DIMENCIONAMENTO DOS BOTOES
		jogar = new JButton("         Jogar         ");
	    c.add(jogar);
	    jogar.addActionListener(this);
	    //jogar.addActionListener(this);
	    voltar=new JButton("Voltar ao menu principal");
		c.add(voltar);
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
		
		if(e.getSource()== jogar){
			this.dispose();
			new TelaIdentificacao().setVisible(true);				
		}
		if(e.getSource()== voltar){
			this.dispose();
			new TelaInicial().setVisible(true);
		} 
		
	}
}
