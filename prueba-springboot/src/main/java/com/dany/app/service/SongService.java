package com.dany.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dany.app.entity.Song;


public interface SongService {

	public Iterable<Song> findAll();
	
	public Page<Song> findAll(Pageable pageable);
	
	public Optional<Song> findByid(Long id);
	
	public Song save(Song user);
	
	public void deleteById(Long id);
}
