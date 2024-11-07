package com.example.dbconexao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // esta linha e para declarar que esta classe e um controller
@RequestMapping("/Pessoas")// e esta e para definir a uri/endpoint de assesso deste controller

public class PessoasController {


    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/Listar")
    public List<Pessoa> listarpessoas() {

        return pessoaRepository.findAll();

    }

    @GetMapping("/Buscar/{nome}")
    public List<Pessoa> buscarPessoas(@PathVariable String nome) {

        return pessoaRepository.buscarPorNome(nome);

    }

    @PostMapping("/Cadastrar")
    public String cadastrar(@RequestBody Pessoa pessoanova) {

        pessoaRepository.save(pessoanova);

        return "Pessoa cadastrada com sucesso!";
    }

    @PutMapping("/Atualizar/{id}")
    public String atualizar(@PathVariable Integer id, @RequestBody Pessoa pessoaatualizada) {

        pessoaatualizada.setId(id);
        pessoaRepository.save(pessoaatualizada);

        return "Pessoa atualizada com sucesso";
    }

    @DeleteMapping("/Deletar/{id}")
    public String deletar(@PathVariable Integer id) {

        pessoaRepository.deleteById(id);

        return "Pessoa deletada com sucesso!";
    }
}
