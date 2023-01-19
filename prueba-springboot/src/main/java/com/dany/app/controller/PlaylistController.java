package com.dany.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dany.app.entity.Playlist;
import com.dany.app.service.PlaylistService;



@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playSer;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Playlist play){
		return ResponseEntity.status(HttpStatus.CREATED).body(playSer.save(play));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable (value = "id") Long playId){
		Optional<Playlist> opPlay = playSer.findByid(playId);
		if(!opPlay.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opPlay);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Playlist playDetails, @PathVariable(value = "id") Long playId){
		Optional<Playlist> play = playSer.findByid(playId);
		
		if(!play.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		play.get().setName(playDetails.getName());
		play.get().setDetails(playDetails.getDetails());
		play.get().setId_song(playDetails.getId_song());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(playSer.save(play.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long playId){
		
		if (!playSer.findByid(playId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		playSer.deleteById(playId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Playlist> readAll() {
		
		List<Playlist> play = StreamSupport.stream(playSer.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return play;
	}
}
