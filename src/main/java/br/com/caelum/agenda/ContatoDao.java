package br.com.caelum.agenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContatoDao {

    private Connection connection;

    public ContatoDao() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato){
        String sql = "insert into contato " +
                "(nome, email, endereco, dataNascimento)" +
                " values(?,?,?,?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4,new Date(contato.getDataNascimento().getTimeInMillis()));

            stmt.execute();
            stmt.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Contato> getLista(){
        try{
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contato");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Contato contato = new Contato();

                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Contato consultaId(int id) {
        try {
            Contato contato = new Contato();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contato where id = " + id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
            }
            rs.close();
            stmt.close();
            return contato;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeContato(Contato contato){
        String sql = "DELETE FROM contato WHERE ID = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1,contato.getId());
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Contato> buscaPorNome(String nome){
//SELECT * FROM contato
//WHERE nome LIKE 'a%';
        try{
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contato WHERE NOME LIKE '" + nome + "%'");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Contato contato = new Contato();

                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void alteraContato(Contato contato){
        String sql = "update contato set nome=?, email=?," +
                "endereco=?, dataNascimento=? where id=?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5,contato.getId());
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }



    }

}