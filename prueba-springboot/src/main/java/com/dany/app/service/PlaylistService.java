package com.dany.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dany.app.entity.Playlist;


public interface PlaylistService {

public Iterable<Playlist> findAll();
	
	public Page<Playlist> findAll(Pageable pageable);
	
	public Optional<Playlist> findByid(Long id);
	
	public Playlist save(Playlist user);
	
	public void deleteById(Long id);
}
