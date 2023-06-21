package br.inatel;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    Connection conn; // Resposavel por fazer a conexao com o MySQL

    Statement satatement; // Preparar as consultas do "SELECT"

    ResultSet result; // Executar as consultas do "SELECT"

    PreparedStatement pst; // Reponsavel por preparar querys de manipalucao(INSERT, UPDATE, DELETE)

    static final String user = "root";
    static final String password = "senha";
    static final String database = "projeto";

    //url de conexao com o servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;


    public void connect() {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro de conexao" + e.getMessage());
        }
    }

    //------------------------INSERIR NOVO REGISTRO NO DATABASE----------------------------
    public boolean insertUser(User user) {
        connect();
        String sql = "INSERT INTO usuario(nome, cpf) VALUES (?,?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getCpf());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
            check = false;
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return check;
    }

    //------------------------BUSCAR UM REGISTRO NO DATABASE----------------------------
    public ArrayList<User> researchUser() {
        connect();
        ArrayList<User> Users = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try {
            satatement = conn.createStatement();
            result = satatement.executeQuery(sql);

            while (result.next()) {
                User userTemp = new User(result.getString("nome"), result.getString("cpf"));
                userTemp.id = result.getInt("id");
                System.out.println("ID = " + userTemp.id);
                System.out.println("Nome = " + userTemp.getNome());
                System.out.println("cpf = " + userTemp.getCpf());
                System.out.println("--------------------------------------------------------------");
                Users.add(userTemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
        } finally {
            try {
                conn.close();
                satatement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return Users;
    }

    //------------------------ATUALIZAR O NOME EM UM REGISTRO NO DATABASE----------------------------
    public boolean updateUser(int id, String nome) {
        connect();
        String sql = "UPDATE usuario SET nome=? WHERE id=?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
            check = false;
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return check;
    }
    //------------------------DELETAR UM USUARIO NO DATABASE----------------------------

    public boolean deleteUser(int id) {
        connect();
        String sql = "DELETE FROM usuario WHERE id=?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
            check = false;
        } finally {
            try {
                conn.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return check;
    }
}