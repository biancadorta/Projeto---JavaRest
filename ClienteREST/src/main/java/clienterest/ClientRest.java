/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienterest;

import java.io.BufferedReader;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author u17172
 */
public class ClientRest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        
         ClientRest cliente = new ClientRest();
        
        String urlGetAlunos = "http://localhost:8080/WebService/webresources/generic/consulta";
        String urlGetAlunoPorRa  = "http://localhost:8080/WebService/webresources/generic/consultaRa/{ra}";
        String urlGetAlunoPorNome = "http://localhost:8080/WebService/webresources/generic/consultaNome/{nome}";
        String urlAlterar = "http://localhost:8080/WebService/webresources/generic/alterar";
        String urlDeletarPorRa = "http://localhost:8080/WebService/webresources/generic/excluirAluno/{ra}";
        String urlIncluir = "http://localhost:8080/WebService/webresources/generic/incluirAluno";

        String getAlunos = cliente.getAlunos(urlGetAlunos);
        String getAlunoByRa = cliente.getAlunoByRa(urlGetAlunoPorRa);
        //String getAlunoByNome = cliente.getAlunoByNome(urlGetAlunoPorNome);
        //String alterar = cliente.alterar(urlAlterar);
       // String deletar = cliente.deletarPorRa( urlDeletarPorRa);
       // String incluir = cliente.incluir(urlIncluir);
        
        //Mostra no formato json
        //System.out.println(getAlunos);
        System.out.println(alterar);
      /* System.out.println(getAlunoByRa);
        System.out.println(getAlunoByNome);
        System.out.println(incluir);
        System.out.println(alterar);
        System.out.println(deletar);*/
        
    }
    
       public String getAlunos(String url) throws MalformedURLException, IOException{
        
        URL objURL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) objURL.openConnection();
        
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        
        System.out.println("\nEnviando requisição 'GET' para URL: " + url);
        
        System.out.println("Response Code: "+ responseCode);
        
        BufferedReader br = 
             new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while((inputLine = br.readLine()) != null){
            response.append(inputLine);
        }
        
        br.close();
        con.disconnect();
        
        return response.toString();
    }
       
   
    
    
    public String alterar(String urlAlterar) throws MalformedURLException, IOException {
        URL objURL = new URL(urlAlterar);
        HttpURLConnection con = (HttpURLConnection) objURL.openConnection();
       
        con.setDoOutput(true);
        
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        
        InputStream is = System.in;
        
        System.out.println("Digite o ra:"); 
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String ra = br.readLine();
        
        System.out.println("Digite o novo nome:");         
        String nomeNovo = br.readLine();
        
        System.out.println("Digite o novo email:");  
        String emailNovo = br.readLine(); 
        
        Aluno aluno = new Aluno(ra,nomeNovo,emailNovo);
        
        OutputStream os = con.getOutputStream();
        
         //instancia um objeto da classe Gson        
        Gson gson = new Gson(); 
       
        //pega os dados do filme, converte para JSON e armazena em string
        String aux = gson.toJson(f);
        
        os.write(out.getBytes());              
        
        int responseCode = con.getResponseCode();
        
        System.out.println("Response Code: "+ responseCode);
        
        BufferedReader br2 = new BufferedReader(new InputStreamReader(con.getInputStream())); 
        StringBuffer response = new StringBuffer();        
        String inputLine;
        
        while((inputLine = br2.readLine())!=null){
            response.append(inputLine);
        
        }
        
        br.close();
        con.disconnect();
        return response.toString();
    }

    public String deletarPorRa(String urlDeletarPorRa) {
        return "";
    }

    public String incluir(String urlIncluir) {
        return "";
    }
       
       

}
