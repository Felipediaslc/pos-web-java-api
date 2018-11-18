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
import br.unipe.pos.web.model.Funcionario;

import br.unipe.pos.web.repository.FuncionarioRepository;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	@GetMapping("/funcionario")
	public List<Funcionario> getAllPersons() {
		return funcionarioRepository.findAll();
	}

	@GetMapping("/funcionario/{id}")
	public Funcionario getPersonById(@PathVariable(value = "id") Long id) {
		return funcionarioRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Person", "id", id));
	}

	@PostMapping("/funcionario")
	public Funcionario createFuncionario(@Valid @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	

	@PutMapping("/funcionario/{id}")
	public Funcionario updateFuncionario(@PathVariable(value = "id") Long id, @Valid @RequestBody Funcionario funcionarioDetails) {

		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Funcionario", "id", id));

		funcionario.setFirstMatricula(funcionarioDetails.getFirstMatricula());
		funcionario.setLastNameFunc(funcionarioDetails.getLastNameFunc());
		funcionario.setLastCurso(funcionarioDetails.getLastCurso());

		Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
		return updatedFuncionario;
	}

	@DeleteMapping("/funcionario/{id}")
	public ResponseEntity<Funcionario> deletePerson(@PathVariable(value = "id") Long id) {

		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Funcionario", "id", id));

		funcionarioRepository.delete(funcionario);
		return ResponseEntity.ok().build();
	}
}