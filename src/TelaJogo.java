import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TelaJogo extends JFrame{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static boolean ativa = true;
	static Musica musica= new Musica();
	
		public TelaJogo(){
			
			if(ativa){
				musica.play();
			}

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
			
			add(new Tabuleiro(this));
			setTitle("Drifts");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(1000,600);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
			
	}
	
	
}