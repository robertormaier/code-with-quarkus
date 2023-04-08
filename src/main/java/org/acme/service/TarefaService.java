package org.acme.service;

import org.acme.model.Tarefa;
import org.acme.repository.TarefaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TarefaService {

    @Inject
    TarefaRepository tarefaRepositor;

    public List<Tarefa> findAllTarefas(){
        return tarefaRepositor.findAll().list();
    }
    public void addTarefa(Tarefa tarefa ){
        tarefaRepositor.persist(tarefa);
    }
    public void deleteTarefa(long id ){
        tarefaRepositor.deleteById(id);
    }
    public List<Tarefa> findAllTarefaByStatus(String status){
        return tarefaRepositor.find("status", status).list();
    }
}
