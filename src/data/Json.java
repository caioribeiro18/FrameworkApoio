package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import coreFrame.Config;

public class Json {
	private Config config = Config.getInstance();
	private String email;
	private String senha;
	private String emailDestinatario;
	private String textoAssunto ;
	private String textoCorpoEmail;
	
	public Json(String nameJson){
		lerJson(nameJson);
	}
	
	public void lerJson(String nameJson){
		JSONParser parser = new JSONParser();

        try {     
            Object obj = parser.parse(new FileReader(config.getTestPath() + "/src/data/"+ nameJson +".json"));

            JSONObject jsonObject =  (JSONObject) obj;

            email = (String) jsonObject.get("email");
            senha = (String) jsonObject.get("senha");
            emailDestinatario = (String) jsonObject.get("emailDestinatario");
            textoAssunto = (String) jsonObject.get("textoAssunto");
            textoCorpoEmail = (String) jsonObject.get("textoCorpoEmail");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public String getTextoAssunto() {
		return textoAssunto;
	}

	public String getTextoCorpoEmail() {
		return textoCorpoEmail;
	}
}
	