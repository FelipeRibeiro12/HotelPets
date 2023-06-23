package br.inatel.connection;

import br.inatel.*;

import java.sql.*;
import java.util.*;

public abstract class Database {

    Connection connection; //Responsavel pela conexao
    Statement statement; //Prepara as consultas do SELECT
    ResultSet result; //Executa as consultas do SELECT
    PreparedStatement pst; //Prepara as querys de manipulacao

    static final String user = "root";
    static final String password = "root";
    static final String database = "bancohotelpets";

    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao feita com sucesso: " + connection);
        } catch (SQLException e) {
            System.out.println("Erro de conexao: " + e.getMessage());
        }
    }

    //--------------------INSERINDO NOVO REGISTRO DE DOG--------------------
    public boolean insertDog(Dog dog) {
        connect();
        String sql = "INSERT INTO dog(coleira, especie, nome, tCpf) VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, dog.getColeira());// concatena nome no primeiro ? do comando
            pst.setString(2, dog.getEspecie());
            pst.setString(3, dog.getNome());
            pst.setString(4, dog.gettCpf());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }


    //--------------------INSERINDO NOVO REGISTRO DE CAT--------------------
    public boolean insertCat(Cat cat) {
        connect();
        String sql = "INSERT INTO cat(coleira, especie, nome, tCpf) VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, cat.getColeira());// concatena nome no primeiro ? do comando
            pst.setString(2, cat.getEspecie());
            pst.setString(3, cat.getNome());
            pst.setString(4, cat.gettCpf());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }


    //--------------------INSERINDO NOVO REGISTRO DE PET--------------------
    public boolean insertPet(Pet pet) {
        connect();
        String sql = "INSERT INTO pet(coleira, especie, nome, tCpf) VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, pet.getColeira());// concatena nome no primeiro ? do comando
            pst.setString(2, pet.getEspecie());
            pst.setString(3, pet.getNome());
            pst.setString(4, pet.gettCpf());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }

    //--------------------INSERINDO NOVO REGISTRO DE TUTOR--------------------
    public boolean insertTutor(Tutor t) {
        connect();
        String sql = "INSERT INTO tutor(cpf, nome, idade) VALUES (?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, t.getCpf());// concatena nome no primeiro ? do comando
            pst.setString(2, t.getNome());
            pst.setInt(3, t.getIdade());
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }

    //------------------------BUSCAR OS PETS DE UM TUTOR----------------------------
    public ArrayList<Pet> researchTutorpets(String cpf){
        connect();
        ArrayList<Pet> Pets = new ArrayList<>();
        String sql = "SELECT p.* FROM pet p JOIN tutor t ON p.tcpf = t.cpf WHERE t.cpf = ?";

        try{

            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            result = pst.executeQuery();

            while(result.next()){
                Pet petTemp = new Pet(result.getInt("coleira"), result.getString("nome"), result.getString("especie"), result.getString("tcpf"));
                //tutorTemp.id = result.getInt("cpf");
                System.out.println("Coleira = " + petTemp.getColeira());
                System.out.println("Nome = " + petTemp.getNome());
                System.out.println("Especie = " + petTemp.getEspecie());
                System.out.println("");
                Pets.add(petTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de conexao " + e.getMessage());
        }finally {
            try {
                connection.close();
                pst.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return Pets;
    }

    //------------------------BUSCAR OS TUTORES----------------------------
    public ArrayList<Tutor> researchTutor() {
        connect();
        ArrayList<Tutor> Tutors = new ArrayList<>();
        String sql = "SELECT * FROM tutor";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Tutor tutorTemp = new Tutor(result.getString("cpf"), result.getString("nome"), result.getInt("idade"));
                System.out.println("Cpf = " + tutorTemp.getCpf());
                System.out.println("Nome = " + tutorTemp.getNome());
                System.out.println("Idade = " + tutorTemp.getIdade());
                System.out.println();
                Tutors.add(tutorTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de conexao " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return Tutors;
    }

    //------------------------ATUALIZAR O NOME DO TUTOR NO REGISTRO DO DATABASE----------------------------
    public boolean updateTutor(String cpf, int idade) {
        connect();
        String sql = "UPDATE tutor SET idade=? WHERE cpf=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idade);
            pst.setString(2, cpf);
            pst.executeUpdate();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return check;
    }

    //------------------------DELETAR UM TUTOR NO DATABASE----------------------------
    public boolean deleteTutor(String cpf) {
        connect();
        String sql = "DELETE FROM tutor WHERE cpf=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return check;
    }

    //------------------------DELETAR UM TUTOR NO DATABASE----------------------------
    public boolean deleteAll() {
        connect();

        try {
            statement = connection.createStatement();

            String[] tables = {"tutor", "pet", "dog", "cat"};

            for (String table : tables) {
                String sql = "DELETE FROM " + table;
                statement.executeUpdate(sql);
            }

            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de conexao " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return check;
    }
}