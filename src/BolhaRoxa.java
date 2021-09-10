import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;


public class BolhaRoxa{
	
	private Image bolhaRoxa;
	private int x ,y;
	Random gerador = new Random();
	private int altura,largura;
	private boolean isVisivel=true;

	
	private double rx =Math.random()*0.4; 
	private double ry =Math.random()*0.4;// 0.480;
	private double vx =Math.random()*0.4;
	private double vy =Math.random()*0.4;// 0.860;
	
	
			

	
	
	
	public BolhaRoxa(int x,int y){
		this.x=x;
		this.y=y;
	
		ImageIcon refBolaRoxa = new ImageIcon(getClass().getResource("Imagens/roxa.png"));
		bolhaRoxa  = refBolaRoxa.getImage();
		
		largura = bolhaRoxa.getWidth(null);
		altura = bolhaRoxa.getHeight(null);
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
	public Image getBolaRoxa() {
		return bolhaRoxa;
	}	
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
	}
}
