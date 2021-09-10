
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;



public class TelaFinal extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton menu; 
	JButton jogarNovamente;
	JDesktopPane c;
	TelaRecordes record;
	static List<Jogador> resultados=new ArrayList<Jogador>();
	static List<Jogador> resultadosNovos=new ArrayList<Jogador>();
	static List<Jogador> remover = new ArrayList<Jogador>();
	Jogador jogador;
	private int pontos = Tabuleiro.pontuacao;
	static File records = new File("records.txt");
	FileWriter escrever = new FileWriter(records);
	int pontoMaximo = 0;
		
	public TelaFinal() throws NumberFormatException, IOException{
		super("Drifts");
		c = new JDesktopPane(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Image fundo = (new ImageIcon(getClass().getResource("Imagens/inicial.png"))).getImage();   
			
			
	         public void paintComponent(Graphics g){
	        	 g.drawImage(fundo,0,0,this); 
	        	 g.setColor(Color.BLACK);
	        	 Font titulo = new Font("Arial",Font.PLAIN|Font.HANGING_BASELINE,20);
	        	 g.setFont(titulo);
	        	 
	        	 g.drawString(jogador.getNome()+ " sua pontuação foi:" +pontos, 200, 60);
	        	 if (pontos!=0&& resultados.size() ==0){
	        		 
	        	 }
	        	 else{
	        		 if(pontos>pontoMaximo){
	        			 
	        				 pontoMaximo = resultados.get(1).getPontuacao();
	        				 g.drawString("Parabéns, você tem um novo record!", 150, 90);
	        			 
	        			 }
	        			 //g.drawString("Parabéns, você tem um novo record!", 150, 90);
	        			 
	        	 
	        	 		
	        	 	}
	         	}
	         
		};
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
         
            	
		//CRIAÇÃO E DIMENCIONAMENTO DOS BOTOES
		c.setLayout(new GridBagLayout());
		//adicionando o botão iniciar
		menu= new JButton("Voltar ao menu");
		c.add(menu,cons);
		cons.gridy=3;
		menu.addActionListener(this);
		
		//adicionando o botão instruçoes
		jogarNovamente = new JButton("Jogar Novamente");
		c.add(jogarNovamente,cons);
		cons.gridy=4;
		jogarNovamente.addActionListener(this);
		
			
		
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
		

		
		salvaJogador();
		
		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
	}
	
       

	public void actionPerformed(ActionEvent e) {			
		if(e.getSource()==menu){
				this.dispose();
				new TelaInicial().setVisible(true);				
			}
		
			if(e.getSource()==jogarNovamente){
				Tabuleiro.setPontuacao(0);
				this.dispose();
				new TelaJogo().setVisible(true);
			}
		
	}
	
	public void salvaJogador() throws NumberFormatException, IOException{
		jogador = new Jogador(TelaIdentificacao.jogador,Tabuleiro.pontuacao);
		resultadosNovos.add(jogador);
		resultados.addAll(resultadosNovos);
		resultadosNovos.clear();
		Tabuleiro.setPontuacao(0);
			
		for ( int i = 0; i < resultados.size(); i++ ) {
            for ( int j = i + 1; j < resultados.size(); j++ ) {
               
                if ( resultados.get( i ).getPontuacao() == resultados.get( j ).getPontuacao() && (resultados.get(i).getNome() == resultados.get(j).getNome())&&
                    !( ( (Object) resultados.get( i ) ).equals( resultados.get( j ) ) )  ) {

                    remover.add(resultados.get(i));
                    i++; 
                    break;
                }
            }
        }
		resultados.removeAll(remover);
		Collections.sort(resultados);
		try(BufferedWriter writer = new BufferedWriter(escrever)){
			for(Jogador record :resultados){
				writer.write(record.getNome()+" = "+record.getPontuacao());
				writer.newLine();
			}

			
		}
	}
 
	
}
			

