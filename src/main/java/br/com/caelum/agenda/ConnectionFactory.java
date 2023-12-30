package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        System.out.println("Conenctando...");

        try{
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:32768/testes_aserafim", "root", "1234");
        } catch(SQLException e){
                throw new RuntimeException(e);
            }

    }
}