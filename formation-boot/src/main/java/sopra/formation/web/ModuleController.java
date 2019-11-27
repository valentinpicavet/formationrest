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

import sopra.formation.model.Module;
import sopra.formation.model.Views;
import sopra.formation.repository.IModuleRepository;


@RestController
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private IModuleRepository moduleRepo;

	@GetMapping("")
	@JsonView(Views.ViewModule.class)
	public List<Module> list() {
		List<Module> modules = moduleRepo.findAll();

		return modules;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewModule.class)
	public Module find(@PathVariable Integer id) {
		Module module = moduleRepo.findById(id).get();

		return module;
	}

	@PostMapping("")
	@JsonView(Views.ViewModule.class)
	public Module create(@RequestBody Module module) {
		return moduleRepo.save(module);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewModule.class)
	public Module update(@RequestBody Module module, @PathVariable Long id) {
		return moduleRepo.save(module);
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewModuleDetail.class)
	public Module findDetail(@PathVariable Integer id) {
		Module module = moduleRepo.findByIdDetail(id);

		return module;
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable  Integer id) {
		moduleRepo.deleteById(id);
	}
}
