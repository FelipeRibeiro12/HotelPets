package br.inatel;

import br.inatel.exceptions.*;
import br.inatel.connection.Database;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidEspecieException, InvalidadeAgeException {

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
            System.out.println("1- Adicionar Tutor e Pets;");
            System.out.println("2- Atualizar idade do Tutor;");
            System.out.println("3- Listar Pets de um Tutor;");
            System.out.println("4- Listar todos os Tutores;");
            System.out.println("5- Remover um Tutor e seus Pets;");
            System.out.println("6- Remover tudo.");
            System.out.println("Entre com a sua opção: ");

            int opcao = input.nextInt(); // Entrada de opção do usuário
            System.out.println();

            switch (opcao) {
                // Adicionar Tutor e Pets
                case 1://ok
                    input.nextLine(); // Limpar o buffer do scanner

                    System.out.println("Cpf do tutor:");
                    String userCpf = input.nextLine();
                    System.out.println();

                    System.out.println("Nome do tutor:");
                    String userNome = input.nextLine();
                    System.out.println();

                    System.out.println("Idade do tutor:");
                    int userIdade= input.nextInt();
                    input.nextLine();
                    System.out.println();

                    Tutor tutor = new Tutor(userCpf, userNome, userIdade);

                    //Criando tutor no banco de dados
                    connect.insertTutor(tutor);

                    //receber erro ao conectar usuario e finalizar a entrada de dados com db

                    int aux = 1;

                    //Adicionando pelo menos 1 pet a cada usuario
                    do {

                        System.out.println("Coleira do pet: ");
                        int petColeira = input.nextInt();
                        input.nextLine();
                        System.out.println();

                        System.out.println("Especie do pet: (Cachorro ou Gato)");
                        String petEspecie = input.nextLine();
                        System.out.println();

                        if (!(petEspecie.equals("Cachorro") || petEspecie.equals("Gato")))
                            throw new InvalidEspecieException();

                        if (petEspecie.equals("Cachorro")) {

                            System.out.println("Nome do cachorro:");
                            String petName = input.nextLine();
                            System.out.println();

                            Dog dog = new Dog(petColeira, petEspecie, petName, userCpf);
                            tutor.addPet(dog);
                            System.out.println();

                            //Criando pet e dog no banco de dados
                            connect.insertPet(dog);
                            //connect.insertDog(dog);
                        }
                        else if (petEspecie.equals("Gato")) {

                            System.out.println("Nome do gato:");
                            String petName = input.nextLine();
                            System.out.println();

                            Cat cat = new Cat(petColeira, petEspecie, petName, userCpf);
                            tutor.addPet(cat);

                            //Criando pet e cat no banco de dados
                            connect.insertPet(cat); // problema com a coluna peso
                            //connect.insertCat(cat); //problema com coluna especie e peso
                        }

                        System.out.println("Deseja adicionar outro pet ao tutor: " + userNome + "? ");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Nao");

                        aux = input.nextInt();
                        input.nextLine();
                        System.out.println();

                    } while (aux != 2);

                    software.addTutor(tutor);

                    break;

                // Atualizar idade do Tutor
                case 2://

                    input.nextLine();

                    System.out.println("Cpf do tutor: ");
                    String att = input.nextLine();

                    System.out.println("Nova idade do tutor: ");
                    int newidade = input.nextInt();

                    if(newidade < 18)
                        throw new InvalidadeAgeException();

                    else
                        connect.updateTutor(att, newidade);

                    break;

                // Listar Pets de um Tutor
                case 3://ok

                    input.nextLine();

                    System.out.println("Cpf do tutor: ");
                    String pesq = input.nextLine();

                    connect.researchTutorpets(pesq);

                    break;

                // Listar todos os Tutores
                case 4://ok

                    input.nextLine();

                    System.out.println("Tutores: ");

                    connect.researchTutor();

                    break;

                // Remover um Tutor e seus Pets
                case 5://ok

                    input.nextLine();

                    System.out.println("Cpf do tutor a ser removido: ");
                    String cpf = input.nextLine();

                    connect.deleteTutor(cpf);

                    break;

                // Remover tudo
                case 6:

                    input.nextLine();

                    System.out.println("Voce esta prestes a apagar tudo!");
                    System.out.println("Deseja continuar?");
                    System.out.println("1- Sim;");
                    System.out.println("2- Nao.");

                    int delete = input.nextInt();

                    if(delete != 1)
                        System.out.println("Operacao cancelada com sucesso!");

                    else
                        connect.deleteAll();

                    break;

            }
        }
    }
}