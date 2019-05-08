/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.cotuca;

import bd.daos.Alunos;
import bd.dbos.Aluno;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author u17172
 */
@Path("generic")
public class Service {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Service
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
    @Path("consultaId/{Id}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)//APPLICATION_JSON
    public String getJson(String ra)throws Exception
    {
        //TODO return proper representation object
        Aluno a = Alunos.getAluno(ra);
        String nome = a.getNome();
        return nome;
    }
}

