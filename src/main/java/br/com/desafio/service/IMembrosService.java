package br.com.desafio.service;

import br.com.desafio.model.Membro;

import java.util.List;

public interface IMembrosService {

    List<Membro> listarMembros();

    void deletarMembro(Long id);

    void salvarMembro(Membro membro);
}
