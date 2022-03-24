package com.AlkemyChallenge.Disney.controller;

import com.AlkemyChallenge.Disney.dto.MovieDTO;
import com.AlkemyChallenge.Disney.dto.MovieDTOBasic;
import com.AlkemyChallenge.Disney.service.MovieService;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Set<MovieDTOBasic>> getAll( ) {
        Set<MovieDTOBasic> MovieDTOBasicList = movieService.getAllMovieDtoBasic();
        return ResponseEntity.ok().body(MovieDTOBasicList);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@Valid @RequestBody MovieDTO movieDTO) {
        MovieDTO movieDTOSave = movieService.save(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDTOSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
