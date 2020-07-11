package com.dao;

import com.mysql.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import com.entity.*;

public class MovieDao {	
	private int count =1;
	
	//BY CATEGORY   **********************************************
	public  ArrayList<Movie> getMoviesByCategory(int categoryId){
		ArrayList<Movie> movies = new ArrayList<>();
        try { 

            Connection conn = ConnectionManager.getConnection();
            String query = "select * from movie where categoryId=?"; 

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, categoryId); 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int movieId = rs.getInt("id");
                String name = rs.getString("name");
                int year = rs.getInt("year");

                Movie movie = new Movie(movieId, name, year);

                movies.add(movie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
	}	
	
	
	//ALL MOVIES **********************************************
	
	public ArrayList<Movie> getAllMovies() {
		ArrayList<Movie> list = new ArrayList<>();
				
		try {
			Connection connection = ConnectionManager.getConnection();
			
			String query = "select * from movie";			
			Statement statement = connection.createStatement();			
			ResultSet rs = statement.executeQuery(query);			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt("id"), rs.getString("name"), rs.getInt("year"));
				list.add(movie);			
			}
		}
		 catch(Exception e){
			 System.out.println(e.getMessage());
			 } 		
		
		return list;
	}
	
	
	// BY FILTERS **********************************************	
	public ArrayList<Movie> getMoviesByFilters( Map<String,String> params) {
		
       ArrayList<Movie> movies = new ArrayList<>();
        
        try { 

            Connection conn = ConnectionManager.getConnection();
            String query = "select * from movie where (? is NULL OR name=?) AND (? is NULL OR directorId=?) AND (? is NULL OR categoryId=?) AND (? is NULL OR year=?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            params.forEach((k, v) -> {
                try {
                    if (v.equals("")) {
                    	ps.setNull(count++, java.sql.Types.NULL);
                    	ps.setNull(count++, java.sql.Types.NULL);
                    }else if(k.equals("name")) {
                    	ps.setString(count++, v);
                    	ps.setString(count++, v);
                    }
                    else {
                    	ps.setInt(count++, Integer.valueOf(v));
                    	ps.setInt(count++, Integer.valueOf(v));
                        }                        
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }); 

            ResultSet rs = ps.executeQuery(); 

            while (rs.next()) { 

                int movieId = rs.getInt("id");
                String name = rs.getString("name");
                int year = rs.getInt("year");

                Movie movie = new Movie(movieId, name, year);
                movies.add(movie);
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
	}
	
}
