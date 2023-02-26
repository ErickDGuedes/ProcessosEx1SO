package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
	}
	//Retornar o Sistema Operacional da Máquina
	public String os() {
		String os = System.getProperty("os.name");
		return os;	
	}
    //Mostra as Configurações IP do SO
	public void ip(String process) {
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				linha = buffer.readLine();
				if(linha == null) {
					linha = buffer.readLine();
				}else if(linha.contains("Wi-Fi") || linha.contains("IPv4") || linha.contains("Ethernet Ethernet ") ) {
					String[] adap = linha.split(" ", 1);
					System.out.println(adap[0]);
			   }
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(IOException e) {
			String msgerro = e.getMessage();
			System.err.println(msgerro);
		}
	}
	//Mostra tempo Médio de resposta com a URL www.google.com.br do SO
	public void ping(String process){
		System.out.println("Aguarde...");
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				linha = buffer.readLine();
				if(linha == null) {
					linha = buffer.readLine();
				}
				else if(linha.contains("dia = ")) {
					String[] Media = linha.split(", ", 4);
			     	System.out.println("Resultado  ==> "+Media[2]);
			 }
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch(IOException e) {
			String msgerro = e.getMessage();
			System.err.println(msgerro);
		}
      }
}



