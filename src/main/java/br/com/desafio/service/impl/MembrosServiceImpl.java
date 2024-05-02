package br.com.desafio.service.impl;

import br.com.desafio.model.Membro;
import br.com.desafio.repository.MembrosRepository;
import br.com.desafio.service.IMembrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembrosServiceImpl implements IMembrosService {

    private final MembrosRepository membrosRepository;

    @Autowired
    public MembrosServiceImpl(MembrosRepository membrosRepository) {
        this.membrosRepository = membrosRepository;
    }

    @Override
    public List<Membro> listarMembros() {
        return membrosRepository.findAll();
    }

    @Override
    public void deletarMembro(Long id) {
        membrosRepository.findById(id).ifPresent(membrosRepository::delete);
    }

    @Override
    public void salvarMembro(Membro membro) {
        membrosRepository.save(membro);
    }
}