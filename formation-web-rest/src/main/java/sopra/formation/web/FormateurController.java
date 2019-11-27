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

import sopra.formation.model.Formateur;
import sopra.formation.model.Views;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/formateur")
public class FormateurController {
	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewFormateur.class)
	public List<Formateur> list() {
		List<Formateur> formateurs = personneRepo.findAllFormateur();
		return formateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public Formateur find(@PathVariable Long id) {
		Formateur formateur = (Formateur) personneRepo.findById(id).get();

		return formateur;
	}
	
	@GetMapping("/{id}/filieres")
	@JsonView(Views.ViewFormateurFiliere.class)
	public Formateur findFilieres(@PathVariable Long id) {
		Formateur formateur = (Formateur) personneRepo.findWithFilieres(id);
		
		return formateur;
	}
	
	@GetMapping("/{id}/modules")
	@JsonView(Views.ViewFormateurModule.class)
	public Formateur findModules(@PathVariable Long id) {
		Formateur formateur = (Formateur) personneRepo.findWithModules(id);
		
		return formateur;
	}
	@GetMapping("/{id}/competences")
	@JsonView(Views.ViewFormateurCompetence.class)
	public Formateur findCompetences(@PathVariable Long id) {
		Formateur formateur = (Formateur) personneRepo.findWithCompetences(id);
		
		return formateur;
	}
	
	

	@PostMapping("")
	@JsonView(Views.ViewFormateur.class)
	public Formateur create(@RequestBody Formateur formateur) {
		return personneRepo.save(formateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public Formateur update(@RequestBody Formateur formateur, @PathVariable Long id) {
		return personneRepo.save(formateur);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personneRepo.deleteById(id);
	}
}
