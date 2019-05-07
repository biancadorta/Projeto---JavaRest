/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.cotuca;

import bd.core.MeuResultSet;
import br.unicamp.cotuca.bd.daos.Alunos;
import br.unicamp.cotuca.bd.dbos.Aluno;
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
     * Retrieves representation of an instance of br.unicamp.cotuca.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/consulta")
    @Produces(MediaType.APPLICATION_JSON)
    public MeuResultSet getAlunos()throws Exception {
        return Alunos.getAlunos();
    }
    
    @GET
    @Path("consultaRa/{ra}") 
    @Consumes(MediaType.APPLICATION_JSON)    
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno getAlunoByRA(@PathParam("ra")String ra)throws Exception {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
       return Alunos.getAluno(ra);
    }
    
    @GET
    @Path("consultaNome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public MeuResultSet getAlunoByNome(@PathParam("nome")String nome) throws Exception {
        //TODO return proper representation object
        return Alunos.getAlunos(nome);
    } 
    
    @POST
    @Path("incluirAluno")    

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(String content) {
    }
}
