package br.inatel.exceptions;

public class InvalidadeAgeException extends Exception{
    public InvalidadeAgeException() {
        super("Precisa ser maior de idade!");
    }
}
