package dogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dogs.model.Usuario;
import dogs.service.DgPrtService;

@Controller
public class WebController {

private final DgPrtService dgPrtService;
    
    public WebController(DgPrtService DgPrtService) {
        this.dgPrtService = DgPrtService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("listaProdutos", dgPrtService.listar());
        return "DogPrinting";    
    }
}
