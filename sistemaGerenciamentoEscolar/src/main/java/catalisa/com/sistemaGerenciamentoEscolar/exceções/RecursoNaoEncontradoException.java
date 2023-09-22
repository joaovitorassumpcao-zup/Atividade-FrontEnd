package catalisa.com.sistemaGerenciamentoEscolar.exceções;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public  class RecursoNaoEncontradoException extends RuntimeException{
    public RecursoNaoEncontradoException(String msg){
        super(msg);
    }
    public RecursoNaoEncontradoException(Object id){
        super("caminho não encontrado! id" + id);
    }
}


