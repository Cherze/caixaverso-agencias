package caixaverso.agencias.repository;

import caixaverso.agencias.model.Agencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgenciaRepository implements PanacheRepository<Agencia> {

    public Agencia findByNomeAgencia(String nome) {

        return find("nome", nome).firstResult();
    }
    public Agencia findByCgc(int cgc){
        return find("cgc", cgc).firstResult();
    }

}
