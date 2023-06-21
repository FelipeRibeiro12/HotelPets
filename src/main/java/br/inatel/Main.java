package br.inatel;

public class Main {
    public static void Main(String[] args) {
        Database db = new Database();
        db.connect();

        //Criar usuarios que serao inseridos no banco de dados
        User user1 = new User("Eduardo", "111.111.111-11");
        User user2 = new User("Thiagp", "222.222.222-22");
        User user3 = new User("Paulo", "333.333.333-33");

        /**
         *         //Inserir esses usuarios no bando de dados
         *         db.insertUser(user1);
         *         db.insertUser(user2);
         *         db.insertUser(user3);
         *
         * */

        //Mostrando os usuarios
        db.researchUser();

        //Atualizando
        System.out.println("Atualizar o nome de um usuario");

        //Mostrando os usuarios
        db.researchUser();

        db.updateUser(1, "Dudu");

        //Deletando um usuario
        System.out.println("Deletando um usuario");
        db.deleteUser(2);

        //Mostrando os usuarios
        db.researchUser();
    }
}