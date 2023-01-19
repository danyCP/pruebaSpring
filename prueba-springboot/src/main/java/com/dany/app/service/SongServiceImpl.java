package com.dany.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dany.app.entity.Song;
import com.dany.app.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	private SongRepository songRep;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Song> findAll() {
		
		return songRep.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Song> findAll(Pageable pageable) {
		
		return songRep.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Song> findByid(Long id) {
		
		return songRep.findById(id);
	}

	@Override
	public Song save(Song user) {
		
		return songRep.save(user);
	}

	@Override
	public void deleteById(Long id) {
		
		songRep.deleteById(id);
	}

}
