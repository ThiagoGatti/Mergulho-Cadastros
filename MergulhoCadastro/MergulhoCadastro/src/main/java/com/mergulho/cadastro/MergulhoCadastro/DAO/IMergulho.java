package com.mergulho.cadastro.MergulhoCadastro.DAO;

import com.mergulho.cadastro.MergulhoCadastro.model.Mergulhos;
import org.springframework.data.repository.CrudRepository;

public interface IMergulho extends CrudRepository<Mergulhos, Integer> {
}
