package sopra.formation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Filiere;
import sopra.formation.model.Views;
import sopra.formation.repository.IFiliereRepository;

@RestController
@RequestMapping("/filiere")
public class FiliereController {
	@Autowired
	private IFiliereRepository filiereRepo;

	@GetMapping("")
	@JsonView(Views.ViewFiliere.class)
	public List<Filiere> list() {
		List<Filiere> filieres = filiereRepo.findAll();

		return filieres;
	}

//	@GetMapping("/{id}")
//	@JsonView(Views.ViewFiliereDetail.class)
//	public Filiere find(@PathVariable Long id) {
//		Filiere filiere = filiereRepo.findWithStagiaire(id);
//
//		return filiere;
//	}

	@PostMapping("")
	public Filiere create(@RequestBody Filiere filiere) {
		return filiereRepo.save(filiere);
	}

	@PutMapping("/{id}")
	public Filiere update(@RequestBody Filiere filiere, @PathVariable Long id) {
		return filiereRepo.save(filiere);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		filiereRepo.deleteById(id);
	}
}
