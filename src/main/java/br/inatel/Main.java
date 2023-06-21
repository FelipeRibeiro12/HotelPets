package br.inatel;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Software software = new Software();

        boolean flag = true;

        System.out.println("Bem-vindo ao Software de Cadastro de Usuários!");

        // Criando o menu
        while (flag) {
            // Opções do menu
            System.out.println("BEM VINDO AO MENU");
            System.out.println("1- adicionar usuario");
            System.out.println("2- listar usuarios");
            System.out.println("3- Sair");
            System.out.println("Entre com a sua opção: ");

            int opcao = input.nextInt(); // Entrada de opção do usuário

            switch (opcao) {
                case 1:
                    input.nextLine(); // Limpar o buffer do scanner

                    System.out.println("Cpf do tutor:");
                    String userCpf = input.nextLine();

                    System.out.println("Nome do tutor:");
                    String userNome = input.nextLine();

                    User user = new User(userCpf, userNome);

                    int aux = 1;

                    //Adicionando pelo menos 1 pet a cada usuario
                    do {
                        System.out.println("Nome do pet:");
                        String petName = input.nextLine();

                        System.out.println("Idade do pet:");
                        int petIdade = input.nextInt();
                        input.nextLine();

                        System.out.println("Raca do pet:");
                        String petRaca = input.nextLine();

                        //System.out.println("Idade do pet:");
                        //int petIdade = input.nextInt();

                        Pet pet = new Pet(petName, petIdade, petRaca);
                        user.addPet(pet);

                        System.out.println("Deseja adicionar outro pet ao usuario " + userNome + "? ");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Nao");

                        aux = input.nextInt();
                        input.nextLine();

                    } while (aux != 2);

                    software.addUser(user);

                    break;

                case 2:
                    System.out.println("Usuários cadastrados: ");

                    ArrayList<User> users = software.getUsers();
                    for (User user2 : users) {
                        System.out.println(user2.getNome() + ", Cpf: " + user2.getCpf());
                        ArrayList<Pet> pets = user2.getPets();

                        System.out.println("Pets: ");
                        for (Pet pet : pets) {
                            System.out.println(pet.getNome() + ", " + pet.getIdade() + " anos, raca: " + pet.getRaca());
                        }
                    }
                    break;

                case 3:

            }
        }
    }
}