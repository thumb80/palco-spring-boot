package com.thumb.palco.repository;

import com.thumb.palco.model.Concerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    List<Concerto> findByArtistTime(@Param("time") String time, @Param("artist") String artist);

    @Query(value = "SELECT DISTINCT artist FROM concerti", nativeQuery = true)
    List<String> findArtists();

    @Query(value = "SELECT DISTINCT city FROM concerti", nativeQuery = true)
    List<String> findCities();

    @Query(value = "SELECT * FROM concerti where time >= :mintime and time <= :maxtime", nativeQuery = true)
    List<Concerto> findElementByMonth(@Param("mintime") LocalDateTime mintime, @Param("maxtime") LocalDateTime maxtime);


    @Query(value = "SELECT * FROM concerti where time >= :mintime and time <= :maxtime and city = :city", nativeQuery = true)
    List<Concerto> findElementByMonthCity(@Param("mintime") LocalDateTime mintime, @Param("maxtime") LocalDateTime maxtime, @Param("city") String city);

    // CREATE
    @Modifying
    @Query(value = "INSERT INTO concerti (id, artist, place, city, time) VALUES (null, :artist, :place,  :city,  :time)", nativeQuery = true)
    @Transactional
    Integer createElement(@Param("artist") String artist, @Param("place") String place, @Param("city") String city, @Param("time") String time);

    // DELETE
    @Modifying
    @Query(value = "DELETE FROM concerti where id = :id", nativeQuery = true)
    @Transactional
    Integer deleteElement(@Param("id") Integer id);

    //UPDATE
    @Modifying
    @Query(value = "UPDATE concerti SET artist = :artist where id = :id", nativeQuery = true)
    @Transactional
    Integer updateElementArtist(@Param("id") Integer id, @Param("artist") String artist);

    @Modifying
    @Query(value = "UPDATE concerti SET place = :place where id = :id", nativeQuery = true)
    @Transactional
    Integer updateElementPlace(@Param("id") Integer id, @Param("place") String place);

    @Modifying
    @Query(value = "UPDATE concerti SET city = :city where id = :id", nativeQuery = true)
    @Transactional
    Integer updateElementCity(@Param("id") Integer id, @Param("city") String city);

    @Modifying
    @Query(value = "UPDATE concerti SET time = :time where id = :id", nativeQuery = true)
    @Transactional
    Integer updateElementTime(@Param("id") Integer id, @Param("time") String time);
    
    @Query(value = "SELECT * FROM concerti WHERE id = :id ORDER BY artist DESC LIMIT 1", nativeQuery = true)
    Concerto findElement(@Param("id") Integer id);

    @Query(value = "SELECT id FROM concerti WHERE artist = :artist and place = :place and city = :city and time = :time", nativeQuery = true)
    Integer findId(@Param("artist") String artist, @Param("place") String place, @Param("city") String city, @Param("time") String time);

    @Query(value = "SELECT id FROM concerti WHERE place = :place and city = :city and time = :time", nativeQuery = true)
    Integer findIdArtist(@Param("place") String place, @Param("city") String city, @Param("time") String time);

    @Query(value = "SELECT id FROM concerti WHERE artist = :artist and city = :city and time = :time", nativeQuery = true)
    Integer findIdPlace(@Param("artist") String artist, @Param("city") String city, @Param("time") String time);

    @Query(value = "SELECT id FROM concerti WHERE artist = :artist and place = :place and time = :time", nativeQuery = true)
    Integer findIdCity(@Param("artist") String artist, @Param("place") String place, @Param("time") String time);

    @Query(value = "SELECT id FROM concerti WHERE artist = :artist and place = :place and city = :city", nativeQuery = true)
    Integer findIdTime(@Param("artist") String artist, @Param("place") String place, @Param("city") String city);
}
