package br.unipe.pos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posweb")
public class PessoaController {
	
	
	@GetMapping("/boot")
	public String teste() {
		return "<h1> SPRING BOOT</h1>";
	}
	

}
