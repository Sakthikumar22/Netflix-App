package com.chainsys.amazon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import com.chainsys.connection.ConnectionUtil;
import com.chainsys.model.Director;
import com.chainsys.model.Movie;
import com.chainsys.model.RegisterClass;



public class MovieDAO {

	
		

		public static void addMovie(int id , String name , int price,int director_id)
				throws SQLException, ClassNotFoundException {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "insert into movie(id,name,price,director_id) values(?,?,?,?) ";
			PreparedStatement preparedStatement = connection .prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, price);
			preparedStatement.setInt(4, director_id);
			int rows = preparedStatement.executeUpdate();
			System.out.println("rows inserted:" + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		public static ArrayList<Director> authorselect() throws SQLException{
			Connection connection = ConnectionUtil.getconnection();
			String sql = "select * from director";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rset = preparedStatement.executeQuery();
			
			ArrayList<Director> arrayList=new ArrayList<Director>();
			while(rset.next()){
				Director director=new Director();
				director.setId(rset.getInt("id"));
				//director.id=rset.getInt("id");
				director.setName(rset.getString("name"));
				//director.name=rset.getString("name");
				
				arrayList.add(director);
				
			}
			ConnectionUtil.close(connection, preparedStatement,rset);
			return arrayList;
		}
		
		public static void addDirector(int id,String name,LocalDate dateofbirth) throws SQLException{
			Connection connection = ConnectionUtil.getconnection();
			String sql = "insert into Director(id,name,dateofbirth) values(?,?,?) ";
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDate(3,Date.valueOf(dateofbirth));
			int rows = preparedStatement.executeUpdate();
			System.out.println("rows inserted:" + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		
		public static void updateMovie(int id,int price) throws SQLException, ClassNotFoundException {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "update movie set price =? where id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, id);
			int rows = preparedStatement.executeUpdate();
			System.out.println("rows updated:" + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		}

		public  static void  deleteMovie(int id) throws SQLException, ClassNotFoundException {
			 Connection connection = ConnectionUtil.getconnection();
			String sql = "delete from movie where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			System.out.println("rows deleted:" + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		}

		public  static ArrayList<Movie> selectMovie(String name) throws SQLException, ClassNotFoundException {
			Connection connection = ConnectionUtil.getconnection();
			String sql = "select id, name,price from movie where name=? order by id asc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			ResultSet rset = preparedStatement.executeQuery();
			ArrayList<Movie> arrayList=new ArrayList<Movie>();
			Movie movie=new Movie();
			while(rset.next()){
			//	Movie movie=new Movie();
				movie.setId(rset.getInt("id"));
			//	movie.name=rset.getString("name");
				movie.setName(rset.getString("name"));
				movie.setPrice(rset.getInt("price"));
			//	movie.price=rset.getInt("price");
				arrayList.add(movie);
				
			}
			
			ConnectionUtil.close(connection, preparedStatement,rset);
			return arrayList;
		}
		
		public static ArrayList<Movie> listMovie() throws SQLException{
			Connection connection = ConnectionUtil.getconnection();
			String sql = "SELECT MOVIE.ID as movieid,movie.name as moviename,PRICE,DIRECTOR.NAME as directorname,DIRECTOR.DateofBirth as directordob FROM MOVIE,DIRECTOR WHERE  DIRECTOR_ID= DIRECTOR.ID order by movieid asc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rset = preparedStatement.executeQuery();
			
			ArrayList<Movie> arrayList=new ArrayList<Movie>();
			
			
			
			while(rset.next()){
				Movie movie=new Movie();				
			//	movie.id=rset.getInt("movieid");
				movie.setId(rset.getInt("movieid"));
				
			//	movie.name=rset.getString("moviename");
				movie.setName(rset.getString("moviename"));
				
				
			//	movie.price=rset.getInt("price");
				movie.setPrice(rset.getInt("price"));
				Director director=new Director();
				director.setName(rset.getString("directorname"));
				director.setDateOfBirth(rset.getDate("directordob").toLocalDate());
				System.out.println(rset.getDate("directordob"));
				movie.setDirector(director);
				arrayList.add(movie);
				
			}
			ConnectionUtil.close(connection, preparedStatement,rset);
			return arrayList;
			
		}
		public static void userinsert(RegisterClass registerClass) throws SQLException{
			Connection connection = ConnectionUtil.getconnection();
			String sql = "insert into register(username,email,password,gender,id) values(?,?,?,?,user_id_seq.nextval)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,registerClass.getUsername());
			preparedStatement.setString(2,registerClass.getEmail());
			preparedStatement.setString(3,registerClass.getPassword());
			preparedStatement.setString(4,registerClass.getGender());
			@SuppressWarnings("unused")
			int rows = preparedStatement.executeUpdate();
			ConnectionUtil.close(connection, preparedStatement, null);
	}
		public static  RegisterClass search(String email,String password) throws SQLException{
			Connection connection = ConnectionUtil.getconnection();
			String sql = "select id from register where email=? and password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
			ResultSet rset = preparedStatement.executeQuery();
			RegisterClass registerclass=new RegisterClass();
			while(rset.next())
			{
				registerclass.setId(rset.getInt("id"));
			}
			
			return registerclass;	
		}
			
			public static  RegisterClass forget(String email) throws SQLException{
				Connection connection = ConnectionUtil.getconnection();
				String sql = "select username,password from register where email=? ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,email);
				
				ResultSet rset = preparedStatement.executeQuery();
				RegisterClass register =new RegisterClass();
				while(rset.next())
				{
					register.setUsername(rset.getString("username"));
					register.setPassword(rset.getString("password"));
					System.out.println(register.getUsername());
				}
				
				return register;	
	}
	}


