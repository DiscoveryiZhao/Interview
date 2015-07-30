package Interviews.ThreatStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by yizhao on 7/29/15.
 */
public class ThreatStream1 {
    private static void threamStream(Connection connection) {
        if (connection == null) {
            System.out.println("Connection object is null.");
            return;
        }
        Statement statement = null;
        ResultSet queryResult = null;
        try {
            statement = connection.createStatement();

            /*
            * define a mysql query, which can do the inner join and Author names should follow the order specified in the Author.rank field.
            * */
            String sql = "SELECT Book.isbn, Book.title, Book.publisher, Book.year, AUTHOR.name FROM Book JOIN AUTHOR ON Book.isbn = AUTHOR.isbn ORDER BY AUTHOR.rank";
            queryResult = statement.executeQuery(sql);


            /*
            * define a treemap for mapping from title to [title, authors, publisher, year]
            * I use treemap instead of a hashmap is because to display the entire catalog, in book title order
            * */
            Map<String, ResultDTO> finalResult = new TreeMap<>();

            /*
            * define a loop to extra the data from queryResult
            * */
            while (queryResult.next()) {
                String title = queryResult.getString("title");
                String publisher = queryResult.getString("publisher");
                int year = queryResult.getInt("year");
                String name = queryResult.getString("name");

                ResultDTO curResultDTO;
                if (finalResult.containsKey(title)) {
                    curResultDTO = finalResult.get(title);
                    curResultDTO.getAuthors().add(name);
                } else {
                    List<String> authors = new ArrayList<>();
                    authors.add(name);
                    curResultDTO = new ResultDTO();
                    curResultDTO.setTitle(title);
                    curResultDTO.setAuthors(authors);
                    curResultDTO.setPublisher(publisher);
                    curResultDTO.setYear(year);
                    finalResult.put(title, curResultDTO);
                }
            }

            /*
            * print out the result to display the entire catalog, in book title order
            * */
            Set<String> titleSet = finalResult.keySet();
            for (String title : titleSet) {
                System.out.println("title: " + finalResult.get(title).getTitle());
                for(String author: finalResult.get(title).getAuthors()){
                    System.out.println("  author: " + author);
                }
                System.out.println("publisher: " + finalResult.get(title).getPublisher() + "  , year:" + finalResult.get(title).getYear());
                System.out.println();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
            * clean up all resources
            * */
            try {
                if(queryResult != null){
                    queryResult.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
    }
}
