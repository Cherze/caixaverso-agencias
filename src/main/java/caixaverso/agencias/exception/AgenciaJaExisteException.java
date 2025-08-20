package caixaverso.agencias.exception;

public class AgenciaJaExisteException extends RuntimeException{
    public AgenciaJaExisteException(String msg){
        super(msg);
    }
}
