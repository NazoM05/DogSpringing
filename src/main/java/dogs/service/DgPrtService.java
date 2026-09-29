package dogs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dogs.model.Produto;
import dogs.repository.DogPrtRepository;

@Service
public class DgPrtService {
	
	private DogPrtRepository dogPrtRepository;	

	public DgPrtService(DogPrtRepository dogPrtRepository) {
		this.dogPrtRepository = dogPrtRepository;
	}



	public List<Produto> listar() {
		List<Produto> lista = new ArrayList<>();
        lista = dogPrtRepository.findAll();
        return lista;
	}
	
	public List<Produto> listarPorCategoria(Integer categoria) {
	    return dogPrtRepository.findByCategoria(categoria);
	}
	
	public boolean ativar(Long id) {
		Optional<Produto> produto = dogPrtRepository.findById(id);
		produto.ifPresent(p -> {
			p.setAtivo(true);
			dogPrtRepository.save(p);
		});
		return produto.isPresent();
		
	}

	public boolean desativar(Long id) {
		Optional<Produto> produto = dogPrtRepository.findById(id);
		produto.ifPresent(p -> {
			p.setAtivo(false);
			dogPrtRepository.save(p);
		});
		return produto.isPresent();
		
	}
	
}
