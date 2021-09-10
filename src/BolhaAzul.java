import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class BolhaAzul {
	
	private Image bolhaAzul;
	private int x ,y;
	Random gerador = new Random();
	private int altura,largura;
	private boolean isVisivel=true;
	private boolean tocada =  false;
	
	public boolean isTocada() {
		return tocada;
	}


	public void setTocada(boolean tocada) {
		this.tocada = tocada;
	}
	private double rx =Math.random()*0.4;; 
	private double ry = Math.random()*0.4;
	private double vx =Math.random()*0.4;
	private double vy =Math.random()*0.4;
	
	
	
	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public BolhaAzul(int x,int y){
		this.x=x;
		this.y=y;
	
		ImageIcon refBolaVerde = new ImageIcon(getClass().getResource("Imagens/azul.png"));
		bolhaAzul  = refBolaVerde.getImage();
		
		largura = bolhaAzul.getWidth(null);
		altura = bolhaAzul.getHeight(null);
		isVisivel = true;
		
	}
	
		
	public void mexer(int x,int y ){
			 this.x=x;
			 this.y=y;
			 
			 this.y=(this.y+(int) ry)%600;
			 this.x=(this.x+(int) rx)%1000;
			 
			//atualiza o valor de rx e ry
			 rx= rx +vx ;
			 ry= ry + vy;
	
		
	}	
	public int getLargura() {
		return largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	public int getX() {
		return (int) x;
	}
	public int getY() {
		return (int) y;
	}
	public boolean isVisivel() {
		return isVisivel;
	}
	public Image getBolaAzul() {
		return bolhaAzul;
	}	
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
	}
}
