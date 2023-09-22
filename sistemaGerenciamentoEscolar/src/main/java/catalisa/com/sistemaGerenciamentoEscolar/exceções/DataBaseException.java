package catalisa.com.sistemaGerenciamentoEscolar.exceções;

public class DataBaseException extends RuntimeException{
    private static final Long serialId = 1L;
    public DataBaseException(String msg){
        super(msg);
    }
}
