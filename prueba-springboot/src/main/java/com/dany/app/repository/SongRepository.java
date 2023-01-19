package com.dany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dany.app.entity.Song;


public interface SongRepository extends JpaRepository<Song, Long>{

}
