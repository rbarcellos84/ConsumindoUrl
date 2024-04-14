package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String cep = JOptionPane.showInputDialog("Informe seu cep:");
		try {
			//consultando cep
			URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
			
			//trazendo os dados da api
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			//lendo e exibindo os dados
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String resultado;
			while((resultado = reader.readLine()) != null) {
				System.out.println(resultado);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
