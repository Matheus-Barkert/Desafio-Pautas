package br.com.compasso.DesafioPauta.service.impl;

import br.com.compasso.DesafioPauta.entity.Associated;
import br.com.compasso.DesafioPauta.exception.EmailInUseException;
import br.com.compasso.DesafioPauta.repository.AssociatedRepository;
import br.com.compasso.DesafioPauta.service.AssociatedService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociatedServiceImpl implements AssociatedService {

    private final AssociatedRepository associatedRepository;

    public AssociatedServiceImpl(AssociatedRepository associatedRepository) {
        this.associatedRepository = associatedRepository;
    }

    @Override
    public List<Associated> list() {
        return associatedRepository.findAll();
    }

    @Override
    public Associated find(String id) {
        return associatedRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Associated register(Associated associated) {
        if(this.list().stream().anyMatch(associated1 -> associated1.getEmail().equals(associated.getEmail())))
            throw new EmailInUseException();
        else
            return associatedRepository.save(associated);
    }

    @Override
    public void delete(String id) {
        associatedRepository.deleteById(id);
    }
}
