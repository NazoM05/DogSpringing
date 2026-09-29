package dogs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import dogs.service.DgPrtService;

@Controller
public class WebController {

    private final DgPrtService dgPrtService;

    public WebController(DgPrtService dgPrtService) {
        this.dgPrtService = dgPrtService;
    }

    // 1. Exibe a página principal
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("listaProdutos", dgPrtService.listar());
        return "DogPrinting";
    }

    // 2. Trata o POST do formulário de cadastro (fetch JSON)
    @PostMapping("/cadastro")
    @ResponseBody
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioRequest request) {
        // Exemplo: delegar para o service
        // dgPrtService.salvarUsuario(request);
        return ResponseEntity.ok("Conta criada com sucesso!");
    }

    // 3. Trata o POST da inclusão de produtos pelo Admin (fetch JSON)
    @PostMapping("/produtos")
    @ResponseBody
    public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutoRequest request) {
        // Exemplo: delegar para o service
        // dgPrtService.salvarProduto(request);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    // DTOs para receber os dados enviadas no corpo do JSON (fetch)
    public record UsuarioRequest(String nome, String email, String senha) {}
    public record ProdutoRequest(String nome, String categoria, Double valor, String linkImage) {}
}