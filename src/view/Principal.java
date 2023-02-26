package view;
import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		
		RedesController redcon = new RedesController();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha:\n1 - Mostrar Nome da Máquina\n2 - Mostrar o IP\n3 - Mostrar Ping\n9 - FIM "));
			switch(opc) {
			//Método 1
			case 1:
			 String os = redcon.os();
			 System.out.println(os);
			break;
			//Método 2
			case 2:
			 redcon.os();
			 if(redcon.os().contains("Windows")) {
			 String processIP = "IPCONFIG";
			 redcon.ip(processIP);
			 }else{
				 String processIP = "IFCONFIG";
				 redcon.ip(processIP);
			 }
			 break;
			//Método 3
			case 3:
			 redcon.os();
			 if(redcon.os().contains("Windows")) {
			 String processPing = "PING -4 -n 10 www.google.com.br";
			 redcon.ping(processPing);
			 }else {
				 String processPing = "PING -4 -c 10 www.google.com.br";
				 redcon.ping(processPing);
			 }
			 break;
			case 9:JOptionPane.showMessageDialog(null, "FIM");
			break;
			default: JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
	}
			}

}
}