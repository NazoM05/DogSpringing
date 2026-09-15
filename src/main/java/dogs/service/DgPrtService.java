package dogs.service;

import java.util.ArrayList;
import java.util.List;

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
	
}
