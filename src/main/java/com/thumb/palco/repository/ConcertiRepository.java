package com.thumb.palco.repository;

import com.thumb.palco.model.Concerto;
import com.thumb.palco.model.PostConcertoInsertRequestBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConcertiRepository extends JpaRepository<Concerto, Integer> {

    // READ
    @Query(value = "SELECT * FROM concerti", nativeQuery = true)
    List<Concerto> findAll();

    @Query(value = "SELECT * FROM concerti WHERE artist = :artist", nativeQuery = true)
    List<Concerto> findByArtist(@Param("artist") String artist);

    @Query(value = "SELECT * FROM concerti where city = :city", nativeQuery = true)
    List<Concerto> findByCity(@Param("city") String city);

    @Query(value = "SELECT * FROM concerti where time = :time", nativeQuery = true)
    List<Concerto> findByTime(@Param("time") String time);

    @Query(value = "SELECT * FROM concerti where artist = :artist and city = :city", nativeQuery = true)
    List<Concerto> findByArtistCity(@Param("artist") String artist, @Param("city") String city);

    @Query(value = "SELECT * FROM concerti where artist = :artist and time = :time", nativeQuery = true)
    List<Concerto> findByArtistTime(@Param("artist") String artist, @Param("time") String time);

    // CREATE
    @Modifying
    @Query(value = "INSERT INTO concerti (id, artist, place, city, time) VALUES (null, :artist, :place,  :city,  :time)", nativeQuery = true)
    @Transactional
    Integer putConcert(@Param("artist") String artist, @Param("place") String place,@Param("city") String city, @Param("time") String time);

    // DELETE
    @Modifying
    @Query(value = "DELETE FROM concerti where artist = :artist and time = :time", nativeQuery = true)
    @Transactional
    Integer deleteConcert(@Param("artist") String artist, @Param("time") String time);

    //UPDATE
    @Modifying
    @Query(value = "UPDATE concerti SET place = :place where artist = :artist and time = :time", nativeQuery = true)
    @Transactional
    Integer updateConcertPlace(@Param("place") String place, @Param("artist") String artist, @Param("time") String time);

    @Modifying
    @Query(value = "UPDATE concerti SET city = :city where artist = :artist and time = :time", nativeQuery = true)
    @Transactional
    Integer updateConcertCity(@Param("city") String city, @Param("artist") String artist, @Param("time") String time);
}
