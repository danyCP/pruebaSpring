package com.dany.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dany.app.entity.Playlist;
import com.dany.app.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	private PlaylistRepository playRep;
	
	@Override
	public Iterable<Playlist> findAll() {
		
		return playRep.findAll();
	}

	@Override
	public Page<Playlist> findAll(Pageable pageable) {
		
		return playRep.findAll(pageable);
	}

	@Override
	public Optional<Playlist> findByid(Long id) {
		
		return playRep.findById(id);
	}

	@Override
	public Playlist save(Playlist user) {
		
		return playRep.save(user);
	}

	@Override
	public void deleteById(Long id) {
		
		playRep.deleteById(id);
	}


}
