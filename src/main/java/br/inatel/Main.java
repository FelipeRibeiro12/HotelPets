package br.inatel;

import java.util.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Database connect = new Database() {
        };

        Software software = new Software();

        boolean flag = true;

        System.out.println("Bem-vindo!");

        // Criando o menu
        while (flag) {
            // Opções do menu
            System.out.println("--MENU--");
            System.out.println("1- Adicionar Tutor e Pets");
            System.out.println("2- Listar Pets de um Tutor");
            System.out.println("3- Sair");
            System.out.println("Entre com a sua opção: ");

            int opcao = input.nextInt(); // Entrada de opção do usuário

            switch (opcao) {
                // Adicionar Tutor e Pets
                case 1:
                    input.nextLine(); // Limpar o buffer do scanner

                    System.out.println("Cpf do tutor:");
                    String userCpf = input.nextLine();

                    System.out.println("Nome do tutor:");
                    String userNome = input.nextLine();

                    System.out.println("Idade do tutor:");
                    int userIdade= input.nextInt();
                    input.nextLine();

                    Tutor tutor = new Tutor(userCpf, userNome, userIdade);

                    /*//Criando tutor no banco de dados
                    connect.insertUser(user);*/

                    int aux = 1;

                    //Adicionando pelo menos 1 pet a cada usuario
                    do {

                        System.out.println("Coleira do pet: ");
                        int petColeira = input.nextInt();
                        input.nextLine();

                        System.out.println("Especie do pet: (Cachorro ou Gato)");
                        String petEspecie = input.nextLine();

                        /*if (!(petEspecie.equals("Cachorro") || petEspecie.equals("Gato")))
                            throw new especieInvalida();*/

                        if (petEspecie.equals("Cachorro")) {

                            System.out.println("Nome do cachorro:");
                            String petName = input.nextLine();

                            System.out.println("Idade do cachorro:");
                            int petIdade = input.nextInt();
                            input.nextLine();

                            Dog dog = new Dog(petColeira, petEspecie, petName, petIdade);
                            tutor.addPet(dog);

                            /*//Criando pet e dog no banco de dados
                            connect.insertPet(dog);
                            connect.insertDog(dog);*/
                        }
                        else if (petEspecie.equals("Gato")) {

                            System.out.println("Nome do gato:");
                            String petName = input.nextLine();

                            System.out.println("Idade do gato:");
                            int petIdade = input.nextInt();
                            input.nextLine();

                            Cat cat = new Cat(petColeira, petEspecie, petName, petIdade);
                            tutor.addPet(cat);

                            /*//Criando pet e cat no banco de dados
                            connect.insertPet(cat);
                            connect.insertCat(cat);*/
                        }
                        else{
                            System.out.println("Especie Invalida");
                        }

                        System.out.println("Deseja adicionar outro pet ao tutor: " + userNome + "? ");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Nao");

                        aux = input.nextInt();
                        input.nextLine();

                    } while (aux != 2);

                    software.addTutor(tutor);

                    break;

                // Listar Cadastrados
                case 2:

                    input.nextLine();

                    System.out.println("Cpf do tutor: ");
                    String pesq = input.nextLine();

                    ArrayList<Tutor> tutors = software.showPets(pesq);

                    break;

                case 3:

            }
        }
    }
}