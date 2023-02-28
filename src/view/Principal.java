package view;
import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		
		RedesController redcon = new RedesController();
		int opc = 0;
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Escolha:\n1 - Mostrar o IP\n2 - Mostrar Ping\n9 - FIM "));
			switch(opc) {
			//Método 1
			case 1:
			 String processIP = "IPCONFIG";
			 redcon.ip(processIP);
			 break;
			//Método 2
			case 2: 
			 String processPing = "PING -4 -n 10 www.google.com.br";
			 redcon.ping(processPing);
			 break;
			case 9:JOptionPane.showMessageDialog(null, "FIM");
			break;
			default: JOptionPane.showMessageDialog(null, "Escolha uma opção válida");
	}
			}

}
}