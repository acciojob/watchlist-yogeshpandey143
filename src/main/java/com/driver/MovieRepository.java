package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class MovieRepository {
	
	
	
	
	private Map<String,Movie> movieList;
	
	private Map<String,Director> directorList;
	private Map<String,List<String>> directorMoviesMapping;

	
	
	
	
	
	public MovieRepository() {
		super();
		// TODO Auto-generated constructor stub
		
		this.movieList = new HashMap<>();
		this.directorList = new HashMap<>();
		 this.directorMoviesMapping = new HashMap<>();
	}

	public void addMovie(Movie movie)
	{
	 movieList.put(movie.getName(), movie);
	 
	
	 
	 
	}
	
	public void addDirector(Director director)
	{
	 directorList.put(director.getName(), director);
	 
	
	 
	 
	}
	
	public Movie getMovie(String movieName)
	{	
	return movieList.get(movieName);		
	}
	
	public Director getDirector(String directorName)
	{
				return directorList.get(directorName);
	}
	
	
	
	
	 public void saveMovieDirectorPair(String movie, String director) {

           if(movieList.containsKey(movie) && directorList.containsKey(director)){
               List<String> mList=new ArrayList<>();
               
               mList=directorMoviesMapping.get(director);
               mList.add(movie);
               directorMoviesMapping.put(director,mList);
       }
   }
	
	
	
	
	
	
	public List<String> allMovie()
	{
		 return new ArrayList<>(movieList.keySet());
		}
	
	
    public List<String> findMoviesFromDirector(String directorName) {
        
        if(directorMoviesMapping.containsKey(directorName)){
           return directorMoviesMapping.get(directorName);
        }
        
        return new ArrayList<>();
  
    }

  
	
	
	 public void deleteDirector(String directorName) {
	        List<String> moviesSet = new ArrayList<>();
	        if(directorMoviesMapping.containsKey(directorName)){
	            moviesSet = directorMoviesMapping.get(directorName);
	            for(String movie : moviesSet){
	                if(movieList.containsKey(movie)){
	                    movieList.remove(movie);
	                }
	            }
	            directorMoviesMapping.remove(directorName);
	        }
	        if(directorList.containsKey(directorName)){
	            directorList.remove(directorName);
	        }
	    }
	 
	 
	 
	 
	    public void deleteAllMovies() {
	        Set<String> movieSet=new HashSet<>();
	        directorList= new HashMap<>();
	        for(String dir : directorMoviesMapping.keySet()){
	            for(String mo : directorMoviesMapping.get(dir)){
	                movieSet.add(mo);
	            }
	        }
	        for(String mo : movieSet){
	            if(movieList.containsKey(mo)){
	                movieList.remove(mo);
	            }
	        }
	        
	        directorMoviesMapping  = new HashMap<>();
	    }

		
	
	
	
	
	
}
