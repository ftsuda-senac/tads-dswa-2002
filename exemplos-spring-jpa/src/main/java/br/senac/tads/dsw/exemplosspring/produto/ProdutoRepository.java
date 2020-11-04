package br.senac.tads.dsw.exemplosspring.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Sintaxe para criar nomes dos métodos do Spring Data JPA:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Produto> findByNome(String nome);

    List<Produto> findByNomeIgnoreCase(String nome);

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // USAR JPQL COM Spring Data JPA
    @Query("SELECT p FROM Produto p WHERE upper(p.nome) LIKE UPPER('%'||:termoBusca||'%')")
    List<Produto> buscaPorNomeJpql(@Param("termoBusca") String nome);

    // USAR SQL NATIVO COM Spring Data JPA
    @Query(value = "SELECT * FROM PRODUTO WHERE upper(nome) LIKE upper('%'||:termoBusca||'%')", nativeQuery = true)
    List<Produto> buscaPorNomeSql(@Param("termoBusca") String nome);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
    Page<Produto> findAllByCategorias_IdIn(List<Integer> ids, Pageable page);

}
