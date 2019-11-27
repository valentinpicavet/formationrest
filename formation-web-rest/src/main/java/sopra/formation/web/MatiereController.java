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

import sopra.formation.model.Evaluation;
import sopra.formation.model.Matiere;
import sopra.formation.model.MatiereId;
import sopra.formation.model.NiveauMatiere;
import sopra.formation.model.Views;
import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.IMatiereRepository;

@RestController
@RequestMapping("/matiere")
public class MatiereController {
	@Autowired
	private IMatiereRepository matiereRepo;

	@GetMapping("")
	@JsonView(Views.ViewMatiere.class)
	public List<Matiere> list() {
		List<Matiere> matieres = matiereRepo.findAll();

		return matieres;
	}

	@GetMapping("/{nom}:{niveau}")
	@JsonView(Views.ViewMatiere.class)
	public Matiere find(@PathVariable String nom, @PathVariable NiveauMatiere niveau ) {
		MatiereId id = new MatiereId(nom, niveau);
		Matiere matiere = matiereRepo.findById(id).get();

		return matiere;
	}

	@PostMapping("")
	public Matiere create(@RequestBody Matiere matiere) {
		return matiereRepo.save(matiere);
	}

	@PutMapping("/{nom}:{niveau}")
	@JsonView(Views.ViewMatiere.class)
	public Matiere update(@RequestBody Matiere matiere, @PathVariable String nom, @PathVariable NiveauMatiere niveau) {
		
		return matiereRepo.save(matiere);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable MatiereId id) {
		matiereRepo.deleteById(id);
	}
	
	@GetMapping("/{nom}:{niveau}/detail")
	@JsonView(Views.ViewMatiereDetail.class)
	public Matiere findWithFormateurs(@PathVariable String nom, @PathVariable NiveauMatiere niveau) {
		Matiere matiere = matiereRepo.findMatiereWithFormateurs(nom, niveau);

		return matiere;
	}
}
