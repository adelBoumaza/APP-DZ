package dz.algerie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.algerie.app.model.Commune;
import dz.algerie.app.model.Wilaya;
import dz.algerie.app.repository.CommuneRepository;
import dz.algerie.app.repository.WilayaRepository;

@RequestMapping("api")
@RestController
public class AlgerieController {

	@Autowired
	private WilayaRepository wilayaRepository;
	
	@Autowired
	private CommuneRepository communeRepository;
	
	@GetMapping(value="/all/wilayas")
	public List<Wilaya> getAllWilaya() {
		return wilayaRepository.findAll();
	}
	
	@GetMapping(value="/all/communes")
	public List<Commune> getAllCommunes() {
		return communeRepository.findAll();
	}
	
	@GetMapping(value="/all/communes/Wilaya/{name}")
	public List<Commune> getAllCommunes(@PathVariable String name) {
		return communeRepository.allCommunesByWilaya(name);
	}
	
	@GetMapping(value="/all/communes/Wilaya/{id}/communes")
	public List<Commune> getAllCommunes(@PathVariable Long id) {
		return communeRepository.allCommunesByWilaya(id);
	}
	
	
	
	
}
