package com.example.dbconexao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

    @Query("select p from pessoas p where p.nome like CONCAT('%', :nome, '%')")
    List<Pessoa> buscarPorNome(@Param("nome") String nome);

}
