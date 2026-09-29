package dogs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dogs.service.DgPrtService;


@RestController
@RequestMapping("/api-rest/produto")
public class ProdutoRestController {

	DgPrtService service;
	
	public ProdutoRestController(DgPrtService service) {
		this.service = service;
	}

    @GetMapping("/ativar/{id}")
    public ResponseEntity<?> ativaProduto(@PathVariable Long id) {
		return service.ativar(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }

    @GetMapping("/desativar/{id}")
    public ResponseEntity<?> desativaProduto(@PathVariable Long id) {
		return service.desativar(id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
