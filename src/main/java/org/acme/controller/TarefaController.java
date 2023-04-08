package org.acme.controller;

import org.acme.model.Tarefa;
import org.acme.service.TarefaService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/api/tarefa")
public class TarefaController {

    @Inject
    TarefaService tarefaService;

    @GET
    public List<Tarefa> findAllTarefa(){

       List<Tarefa> tarefas = new ArrayList<>();

       try {
            tarefas = tarefaService.findAllTarefas();
       }
       catch (Exception e){
           e.printStackTrace();
       }
       return  tarefas;
   }


    @GET()
    @Path("findAllTarefaByStatus/{status}")
    public List<Tarefa> findAllTarefaByStatus(@PathParam("status") String status){

        List<Tarefa> tarefas = new ArrayList<>();

        try {
            tarefas = tarefaService.findAllTarefas();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  tarefas;
    }
    @POST
    @Transactional
    public void addTarefa(Tarefa tarefa){

        tarefa.setStatus("pendente");

        tarefaService.addTarefa(tarefa);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteTarefa(@PathParam("id")long id){
        tarefaService.deleteTarefa(id);
    }
}
