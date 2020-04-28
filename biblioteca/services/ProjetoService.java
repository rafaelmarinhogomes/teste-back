package br.com.biblioteca.services;

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.repository.ProjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjetoService {
    @Autowired
    ProjetosRepository projetosRepository;

    public void save(Projeto projeto) {
        projetosRepository.save(projeto);
    }

    public List<Projeto> listAll() {
        return (List<Projeto>) projetosRepository.findAll();
    }

    public Projeto get(Long id) {
        return projetosRepository.findOne(id);
    }

    public void delete(Long id) {
        projetosRepository.delete(id);
    }

    public List<Projeto> search(String keyword) {
        return projetosRepository.search(keyword);
    }
}
