package caixaverso.agencias.repository;

import caixaverso.agencias.model.Agencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class AgenciaRepository implements PanacheRepository<Agencia> {

    public Optional<Agencia> findByNomeAgencia(String nome) {

        return find("nomeAgencia", nome).firstResultOptional();
    }
    public Optional<Agencia> findByCgc(int cgc){
        return find("cgc", cgc).firstResultOptional();
    }

}
