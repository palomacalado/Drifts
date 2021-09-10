import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Jogador implements Comparable<Jogador>{

	private int pontuacao;
	private String nome;
		
	public Jogador(){
		
	}
	
	public Jogador(String nome, int pontuacao){
				this.nome = nome;
				this.pontuacao = pontuacao;
	}
	

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPontuacao() {
		return pontuacao;
	}

	public String getNome() {
		return nome;
	}

	
	public int compareTo(Jogador outroJogador) {
		
		
		return outroJogador.getPontuacao() - this.pontuacao;
	}
	
public ArrayList<Jogador> recuperarRecords() throws NumberFormatException, IOException{
		
		ArrayList<Jogador> records = new ArrayList<>();
		
		
		File file =new File("records.txt");
		FileReader ler = new FileReader(file);
		BufferedReader reader = new BufferedReader(ler);
		String line = null;
		
		while((line = reader.readLine())!= null){
			String[] t =line.split(" = ");
			int inteiro = Integer.parseInt(t[1]);
			Jogador record = new Jogador(t[0],inteiro);
			records.add(record);
		}
		reader.close();
		return records;
}
	
}
