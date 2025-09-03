package caixaverso.agencias.repository;

import caixaverso.agencias.model.Agencia;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AgenciaRepository implements PanacheRepository<Agencia> {

    public Optional<Agencia> findByNomeAgencia(String nome) {

        return find("nomeAgencia", nome).firstResultOptional();
    }
    public Agencia findByCgc(int cgc){

        return find("cgc", cgc).firstResult();
    }

    public List<Agencia> findByUf(String estado){
        return find("LOWER(estado) LIKE LOWER(?1)", "%" + estado + "%").stream().toList();
    }
    public List<Agencia> findByCidade(String cidade) {
        return find("LOWER(cidade) LIKE LOWER(?1)", "%" + cidade + "%").stream().toList();
    }

}
