import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;


public class BolhaVermelha {
	
	private int x=300;
	private int y=200;
	private int largura,altura;
		
	private Image bolhaVermelha;
	private boolean isVisivel;
	
	

	public BolhaVermelha(){
		
		
		ImageIcon refBolaVermelha = new ImageIcon(getClass().getResource("Imagens/vermelha.png"));
						
		bolhaVermelha= refBolaVermelha.getImage();
		
		
		
		
		this.largura=bolhaVermelha.getWidth(null);
		this.altura=bolhaVermelha.getHeight(null);
	}	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isVisivel() {
		return isVisivel;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}	
	public Image getBolaVermelha() {
		return bolhaVermelha;
	}
	public void mouseMoved (MouseEvent e) {
		
		x = e.getX();
		y = e.getY();
		
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
	}
	

	
}
