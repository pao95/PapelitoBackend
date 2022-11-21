package com.api.Api.Rest.services;
import com.api.Api.Rest.entities.Ciudad;
import com.api.Api.Rest.repositories.BaseRepository;
import com.api.Api.Rest.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad, Long> implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;
    public CiudadServiceImpl(BaseRepository<Ciudad,Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public List<Ciudad> getCiudadesByProvincia(Long idProvincia) throws Exception {

        List<Ciudad> ciudads = ciudadRepository.findAllByIdProvincia(idProvincia);
        return ciudads;
    }
}
