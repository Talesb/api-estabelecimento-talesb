package br.edu.infnet.api.estabelecimentotalesb.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.api.estabelecimentotalesb.model.domain.Estabelecimento;

@Repository
public interface EstabelecimentoRepository extends CrudRepository<Estabelecimento, Integer> {

}
