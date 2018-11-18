package br.unipe.pos.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.web.model.Produto;



/**
 * This use JpaRepository that extends the PagingAndSortingRepository that extends CRUDRepository.
 */
@Repository            /**a Classe JPAREpository garante todas as operaçãoes de cadastro, todas os metodos*/
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
