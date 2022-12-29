package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MovieService {
	

	
	@Autowired
	MovieRepository  movieRepository;
	
	
	
	public void addMyMovie(Movie movie)
	{
		movieRepository.addMovie(movie);
		
	}
	
	public void addMyDirector(Director director)
	{
		movieRepository.addDirector(director);
		
	}
	
	
	public Movie getMyMovie(String movieName)
	{
		return movieRepository.getMovie(movieName);
	}
	
	
	public Director getMyDirector(String directorName)
	{
		return movieRepository.getDirector(directorName);
	}
	
	
	public List<String> getAllMovie()
	{
		return movieRepository.allMovie();
	}
	
    public void createMovieDirectorPair(String movie,String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }

	
	  public void deleteDirector(String directorName){
	        movieRepository.deleteDirector(directorName);
	    }
	   
	  public void deleteAllMovies(){
	        movieRepository.deleteAllMovies();
	    }
	


}
