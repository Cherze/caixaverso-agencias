package caixaverso.agencias.exception;

public class AgenciaNaoExisteException extends RuntimeException{
    public AgenciaNaoExisteException(String msg){
        super(msg);
    }
}
