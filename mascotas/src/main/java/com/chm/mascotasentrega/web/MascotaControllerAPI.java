package com.chm.mascotasentrega.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.chm.mascotasentrega.data.MascotaRepository;
import com.chm.mascotasentrega.model.Mascota;

@RestController
@RequestMapping(path="/rest", produces="application/json")

public class MascotaControllerAPI {
	
	@Autowired
	private MascotaRepository mascotaRepo;
	
	@GetMapping("/{id}")
	public ResponseEntity<Mascota> mascotaById(@PathVariable("id") Long id) {
	Optional<Mascota> optMascota = mascotaRepo.findById(id);
	if(optMascota.isPresent()) {
	return new ResponseEntity<>(optMascota.get(), HttpStatus.OK);
	}
	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/maskotas")
	public Iterable<Mascota> getAllMascotas() {
		
		return mascotaRepo.findAll();
	}

	@PostMapping(path="/maskotas", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mascota postMascota(@RequestBody Mascota mascota) {
		return mascotaRepo.save(mascota);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteMascota(@PathVariable("id") Long id) {
	mascotaRepo.deleteById(id);
	}

	@GetMapping("/recent")
	public Iterable<Mascota> getOldMascotas(){
	PageRequest page = PageRequest.of(0, 20, Sort.by("fecha_nac").ascending());
	return mascotaRepo.findAll(page);
	}
	

}
