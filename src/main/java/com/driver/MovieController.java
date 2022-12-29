package com.driver;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
	
	
	@Autowired
	MovieService movieService;
	
	@PostMapping("/add-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie)
	{
		movieService.addMyMovie( movie);
		return new ResponseEntity<>("movie added successfully!",HttpStatus.CREATED );
	}
	
	
	@PostMapping("/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director director)
	{
		movieService.addMyDirector( director);
		return new ResponseEntity<>("director added successfully!",HttpStatus.CREATED );
	}
	
	
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie,@RequestParam String director){
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie Director pair added succesfully", HttpStatus.CREATED);
    }
	
	
	
	@GetMapping("/get-movie-by-name/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
	{
	    Movie movie =  movieService.getMyMovie(name); 
		return new ResponseEntity<>(movie,HttpStatus.ACCEPTED );
		
	}
	
	
	@GetMapping("/get-director-by-name/{name}")
	public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
	{
	    Director director =  movieService.getMyDirector(name); 
		return new ResponseEntity<>(director,HttpStatus.ACCEPTED );
		
	}
	
	@GetMapping("/get-all-movies")
	public ResponseEntity<List<String>>findAllMovies()
	{
		
		List<String> movielist = movieService.getAllMovie();
		return new ResponseEntity<>(movielist ,HttpStatus.OK );
	}
	
	@DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>  deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirector(directorName);
        return new ResponseEntity<>(directorName + "Successfully Removed",HttpStatus.MOVED_PERMANENTLY);
    }
	
	
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllMovies();
        return new ResponseEntity<>("All directors are Deleted Successfully",HttpStatus.MOVED_PERMANENTLY);
    }
	
	

}
