package br.unipe.pos.web.PersonController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.pos.web.exception.PersonNotFoundException;

import br.unipe.pos.web.model.Produto;
import br.unipe.pos.web.repository.ProdutoRepository;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produto")
	public List<Produto> getAllPersons() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/{id}")
	public Produto getPersonById(@PathVariable(value = "id") Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Produto", "id", id));
	}

	@PostMapping("/produto")
	public Produto createProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("/produto/{id}")
	public Produto updateProduto(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto produtoDetails) {

		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Produto", "id", id));

		produto.setFirstNameProduto(produtoDetails.getFirstNameProduto());
		produto.setLastValidade(produtoDetails.getLastValidade());
		produto.setLastPreco(produtoDetails.getLastPreco());

		Produto updatedProduto = produtoRepository.save(produto);
		return updatedProduto;
	}

	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Produto> deletePerson(@PathVariable(value = "id") Long id) {

		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Produto", "id", id));

		produtoRepository.delete(produto);
		return ResponseEntity.ok().build();
	}
}

