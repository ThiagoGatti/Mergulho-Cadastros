package com.mergulho.cadastro.MergulhoCadastro.controller;

import com.mergulho.cadastro.MergulhoCadastro.DAO.IMergulho;
import com.mergulho.cadastro.MergulhoCadastro.model.Mergulhos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/mergulho")
public class Controller {

    @Autowired
    private IMergulho dao;

    @GetMapping
    public List<Mergulhos> listaMergulhos() {
        return (List<Mergulhos>) dao.findAll();
    }

    @PostMapping
    public Mergulhos criarMergulho(@RequestBody Mergulhos mergulhos) {
        Mergulhos mergulhosNovo = dao.save(mergulhos);
        return mergulhosNovo;

    }

    @PutMapping
    public Mergulhos editarMergulho(@RequestBody Mergulhos mergulhos) {
        Mergulhos mergulhosNovo = dao.save(mergulhos);
        return mergulhosNovo;
    }
    @DeleteMapping("/{id}")
    public Optional<Mergulhos> excluirMergulho(@PathVariable Integer id) {
        Optional<Mergulhos> mergulhos = dao.findById(id);
        dao.deleteById(id);
        return mergulhos;

    }
}