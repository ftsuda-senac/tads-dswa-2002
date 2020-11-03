package br.senac.tads.dsw.exemplosspring.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    // Sintaxe para criar nomes dos métodos do Spring Data JPA:
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    
    Optional<Produto> findByNome(String nome);
    
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions
    Page<Produto> findAllByCategorias_IdIn(List<Integer> ids, Pageable page);

}
