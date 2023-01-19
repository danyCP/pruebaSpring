package com.dany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dany.app.entity.Playlist;


public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

}
