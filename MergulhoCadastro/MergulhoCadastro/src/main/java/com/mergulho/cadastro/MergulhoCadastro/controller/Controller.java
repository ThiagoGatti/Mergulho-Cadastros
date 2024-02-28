package com.mergulho.cadastro.MergulhoCadastro.controller;

import com.mergulho.cadastro.MergulhoCadastro.DAO.IMergulho;
import com.mergulho.cadastro.MergulhoCadastro.model.Mergulhos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> criarMergulho(@RequestBody Mergulhos mergulhos) {
        try {
            Mergulhos mergulhosNovo = dao.save(mergulhos);
            System.out.println(mergulhos);
            return new ResponseEntity<>(mergulhosNovo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao criar o mergulho: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> editarMergulho(@RequestBody Mergulhos mergulhos) {
        try {
            Mergulhos mergulhosNovo = dao.save(mergulhos);
            return new ResponseEntity<>(mergulhosNovo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao editar o mergulho: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirMergulho(@PathVariable Integer id) {
        try {
            Optional<Mergulhos> mergulhos = dao.findById(id);
            if (mergulhos.isPresent()) {
                dao.deleteById(id);
                return new ResponseEntity<>(mergulhos, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Mergulho não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao excluir o mergulho: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
