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

import com.dany.app.entity.Song;
import com.dany.app.service.SongService;

@RestController
@RequestMapping("/api/song")
public class SongController {

	@Autowired
	private SongService songSer;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Song song){
		return ResponseEntity.status(HttpStatus.CREATED).body(songSer.save(song));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable (value = "id") Long songId){
		Optional<Song> opSong = songSer.findByid(songId);
		if(!opSong.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(opSong);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Song songDetails, @PathVariable(value = "id") Long songId){
		Optional<Song> song = songSer.findByid(songId);
		
		if(!song.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		song.get().setTitle(songDetails.getTitle());
		song.get().setArtista(songDetails.getArtista());
		song.get().setAlbum(songDetails.getAlbum());
		song.get().setYear(songDetails.getYear());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(songSer.save(song.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long songId){
		
		if (!songSer.findByid(songId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		songSer.deleteById(songId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Song> readAll() {
		
		List<Song> song = StreamSupport.stream(songSer.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return song;
	}
}
