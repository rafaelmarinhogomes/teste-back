package br.com.biblioteca.repository;

import br.com.biblioteca.model.Projeto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the Projetos entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjetosRepository extends CrudRepository<Projeto, Long> {

	@Query(value = "SELECT c FROM Projeto p WHERE p.name LIKE '%' || :keyword || '%'")
	public List<Projeto> search(@Param("keyword") String keyword);
}

