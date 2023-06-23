package br.inatel;

import br.inatel.exceptions.*;
import br.inatel.connection.Database;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InvalidEspecieException, InvalidadeAgeException, InvalidOptionException {

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
            System.out.println("3- Listar os Cachorros ou Gatos;");
            System.out.println("4- Listar Pets de um Tutor;");
            System.out.println("5- Listar todos os Tutores;");
            System.out.println("6- Remover um Tutor e seus Pets;");
            System.out.println("7- Remover tudo;");
            System.out.println("8- Sair.");
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
                    int auxUserIdade= input.nextInt();
                    int userIdade;

                    if(auxUserIdade < 18)
                        throw new InvalidadeAgeException();

                    else
                        userIdade = auxUserIdade;

                    Tutor tutor = new Tutor(userCpf, userNome, userIdade);

                    System.out.println();

                    //Criando tutor no banco de dados
                    connect.insertTutor(tutor);

                    //receber erro ao conectar usuario e finalizar a entrada de dados com db

                    int aux = 1;

                    //Adicionando pelo menos 1 pet a cada usuario
                    do {
                        Pet pet = new Pet();

                        pet.settCpf(userCpf);
                        System.out.println("Coleira do pet: ");
                        int petColeira = input.nextInt();
                        pet.setColeira(petColeira);

                        input.nextLine();
                        System.out.println();

                        System.out.println("Especie do pet: (Cachorro ou Gato)");
                        String petEspecie = input.nextLine();
                        System.out.println();

                        if (!(petEspecie.equals("Cachorro") || petEspecie.equals("Gato")))
                            throw new InvalidEspecieException();

                        else {
                            pet.setEspecie(petEspecie);

                            System.out.println("Nome do pet:");
                            String petName = input.nextLine();
                            pet.setNome(petName);
                            connect.insertPet(pet);

                            System.out.println();

                            if (petEspecie.equals("Cachorro")) {
                                Dog dog = new Dog();

                                dog.setColeira(petColeira);

                                System.out.println("Cor do cachorro: ");
                                String dogCor = input.nextLine();
                                dog.setCor(dogCor);
                                connect.insertDog(dog);

                                System.out.println();
                            }

                            else {
                                Cat cat = new Cat();

                                cat.setColeira(petColeira);

                                System.out.println("Pelagem do gato: ");
                                String catPelo = input.nextLine();
                                cat.setPelagem(catPelo);
                                connect.insertCat(cat);

                                System.out.println();
                            }
                        }

                        System.out.println("Deseja adicionar outro pet ao tutor: " + userNome + "? ");
                        System.out.println("1- Sim");
                        System.out.println("2- Nao");

                        aux = input.nextInt();
                        input.nextLine();
                        System.out.println();

                    } while (aux != 2);

                    software.addTutor(tutor);

                    break;

                // Atualizar idade do Tutor
                case 2:
                    input.nextLine();

                    System.out.println("Cpf do tutor: ");
                    String cpfAtt = input.nextLine();
                    System.out.println();

                    System.out.println("Nova idade do tutor: ");
                    int newIdade = input.nextInt();

                    if(newIdade < 18)
                        throw new InvalidadeAgeException();

                    else
                        connect.updateTutor(cpfAtt, newIdade);

                    break;

                case 3:
                    input.nextLine();

                    System.out.println("1- Listar os Cachorros;");
                    System.out.println("2- Listar os Gatos");
                    int aux3 = input.nextInt();

                    if(aux3 == 1)
                        connect.researchDogs();

                    else if(aux3 == 2)
                        connect.researchCats();

                    else throw new InvalidOptionException();

                    break;

                // Listar Pets de um Tutor
                case 4:
                    input.nextLine();

                    System.out.println("Cpf do tutor: ");
                    String pesq = input.nextLine();

                    connect.researchTutorpets(pesq);

                    break;

                // Listar todos os Tutores
                case 5:
                    input.nextLine();

                    System.out.println("Tutores: ");

                    connect.researchTutor();

                    break;

                // Remover um Tutor e seus Pets
                case 6:
                    input.nextLine();

                    System.out.println("Cpf do tutor a ser removido: ");
                    String cpf = input.nextLine();

                    connect.deleteTutor(cpf);

                    break;

                // Remover tudo
                case 7:
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

                case 8:
                    flag = false;

                    System.out.println("Programa encerrado.");

                    break;


            }
        }
    }
}