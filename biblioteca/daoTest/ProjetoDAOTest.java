package br.com.biblioteca.daoTest;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.model.Risco;
import br.com.biblioteca.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ProjetoDAOTest {

    public void abonoHorasFaltantesTest(){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("users-db");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Projeto newProjeto = new Projeto();
        Risco risco = Risco.ALTO_RISCO;
        Status status = Status.ANALISE_APROVADA;

        newProjeto.setNome("Teste Nome");
        newProjeto.setDataInicio(ZonedDateTime.of(2020, 4,28, 0,0,0,  0, ZoneId.of("UTC")));
        newProjeto.setIdgerente((long) 1);
        newProjeto.setDataPrevisaoFim(ZonedDateTime.of(2020, 5,20, 0,0,0,  0, ZoneId.of("UTC")));
        newProjeto.setDataFim(ZonedDateTime.of(2020, 5,19, 0,0,0,  0, ZoneId.of("UTC")));
        newProjeto.setOrcamento(2700F);
        newProjeto.setDescricao("Teste descrição do projeto");
        newProjeto.setStatus(status);
        newProjeto.setRisco(risco);

        entityManager.persist(newProjeto);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
