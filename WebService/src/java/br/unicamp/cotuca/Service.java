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
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
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

    private ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
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
        
        try{
           MeuResultSet rs = Alunos.getAlunos();                    

            while(rs.next()){          
                Aluno aluno = new Aluno();
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                listaAlunos.add(aluno);             
               
            }
            //vai estar na ultima linha da tabela, porem nao incluimos ela, pois saimos do while
            Aluno aluno = new Aluno();
            aluno.setRa(rs.getString("ra"));
            aluno.setNome(rs.getString("nome"));
            aluno.setEmail(rs.getString("email"));
            listaAlunos.add(aluno);          
        }
        catch(Exception erro){
            erro.getMessage();
        } 
        
        return listaAlunos;
    }
    
    @GET
    @Path("consultaRa/{ra}") 
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno getAlunoByRA(@PathParam("ra")String ra)throws Exception {

        return Alunos.getAluno(ra);           
    }       
    
    @GET
    @Path("consultaNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Aluno> getAlunoByNome(@PathParam("nome")String nome) throws Exception{      
        ArrayList<Aluno> lista2 = new ArrayList<>();
        
        try{
            MeuResultSet rs = Alunos.getAlunos(nome);           

            while(rs.next()){          
                Aluno aluno = new Aluno();
                aluno.setRa(rs.getString("ra"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                lista2.add(aluno);             

            }
            //vai estar na ultima linha da tabela, porem nao incluimos ela, pois saimos do while
            Aluno aluno = new Aluno();
            aluno.setRa(rs.getString("ra"));
            aluno.setNome(rs.getString("nome"));
            aluno.setEmail(rs.getString("email"));
            lista2.add(aluno);          
        }
        catch(Exception erro){
            erro.getMessage();
        }         
        
        return lista2;      
    }    
 
    
    @POST
    @Path("incluirAluno")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Aluno> incluiAluno(Aluno aluno)throws Exception{        
        Alunos.incluir(aluno);
        return getAlunos();        
    } 
   
   //•	PUT, para alterar nome e email do aluno no banco de dados
   
   @PUT
   @Path("alterar")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Aluno alterarAluno(Aluno aluno) throws Exception{
       Alunos.alterar(aluno);
       return aluno;
       //return getAlunos();
   }   
   
   //•	DELETE, para excluir o aluno do banco de dados
   @GET
   @Path("excluirAluno/{ra}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   
   public ArrayList<Aluno> excluirAluno(@PathParam("ra")String ra) throws Exception{
       Alunos.excluir(ra);
       return getAlunos();
   }
   
}
