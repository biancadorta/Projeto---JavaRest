/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.cotuca;

import bd.core.MeuResultSet;
import br.unicamp.cotuca.bd.daos.Alunos;
import br.unicamp.cotuca.bd.dbos.Aluno;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author u17165
 */
@Path("generic")
public class Service {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Service() {
    }

   
     /**
     * Retrieves representation of an instance of br.unicamp.cotuca.Service
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of Service
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @GET
    @Path("/consulta")
    @Produces(MediaType.APPLICATION_JSON)    
    public ArrayList<Aluno> getAlunos()throws Exception {
        
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
        try{
            MeuResultSet resultado = Alunos.getAlunos();

           for(;;)
            {
                Aluno aluno = new Aluno();
                aluno.setRa(resultado.getString("ra"));
                aluno.setRa(resultado.getString("nome"));
                aluno.setRa(resultado.getString("email"));
                listaAlunos.add(aluno);
                
                if(resultado.isLast())
                    break;
                
                resultado.next();
            }
        }
        catch(Exception erro){
        }
       
        
        return listaAlunos;
    }
    
    @GET
    @Path("consultaRa/{ra}") 
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    public String getAlunoByRA(@PathParam("ra")String ra)throws Exception {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return Alunos.getAluno(ra).toString();
        
        
    }
    
    
    
    @GET
    @Path("consultaNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Aluno> getAlunoByNome(@PathParam("nome")String nome)  {
        //TODO return proper representation object
       return null;
    }    
 
    
    @POST
    @Path("incluirAluno")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MeuResultSet incluiAluno(Aluno aluno) throws Exception{
        Alunos.incluir(aluno);
        return Alunos.getAlunos(); 
    }
    
    /*
         • DELETE, para excluir o aluno do banco de dados.
    */


 
}
