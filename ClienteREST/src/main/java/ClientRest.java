/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author u17165
 */
public class ClientRest {
    
    public void main(String[]args){
        ClientRest cliente = new ClientRest();
        
        String urlGetAlunos = "http://localhost:8080/WebService/webresources/generic/consulta";
        String urlGetAlunoPorRa  = "http://localhost:8080/WebService/webresources/generic/consultaRa/{ra}";
        String urlGetAlunoPorNome = "http://localhost:8080/WebService/webresources/generic/consultaNome/{nome}";
        String urlAlterar = "http://localhost:8080/WebService/webresources/generic/alterar";
        String urlDeletarPorRa = "http://localhost:8080/WebService/webresources/generic/excluirAluno/{ra}";
        String urlIncluir = "http://localhost:8080/WebService/webresources/generic/incluirAluno";

        //String getAlunos = cliente.getAlunos(urlGetAlunos);
        //String getAlunoByRa = cliente.getAlunoByRa(urlGetAlunoPorRa);
        //String getAlunoByNome = cliente.getAlunoByNome(urlGetAlunoPorNome);
        String alterar = cliente.alterar(urlAlterar);
        String deletar = cliente.deletarPorRa( urlDeletarPorRa);
        String incluir = cliente.incluir(urlIncluir);
        
        //Mostra no formato json
        //System.out.println(getAlunos);
        //System.out.println(getAlunoByRa);
        //System.out.println(getAlunoByNome);
        System.out.println(incluir);
        System.out.println(alterar);
        System.out.println(deletar);        
    }

    public String alterar(String urlAlterar){
        
    }

    public String deletarPorRa(String urlDeletarPorRa) {
       
    }

    public String incluir(String urlIncluir) {
        
    }
    
    
}
