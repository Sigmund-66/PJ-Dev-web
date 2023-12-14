package com.example.demo.MVC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> getAllLocalizacoes() {
        return localizacaoRepository.findAll();
    }

    public Optional<Localizacao> getLocalizacaoById(Long id) {
        return localizacaoRepository.findById(id);
    }

    public Localizacao saveLocalizacao(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    public void deleteLocalizacao(Long id) {
        localizacaoRepository.deleteById(id);
    }

    public Localizacao updateLocalizacao(Long id, Localizacao newLocalizacao) {
        return localizacaoRepository.findById(id).map(existingLocalizacao -> {
            existingLocalizacao.setLatitude(newLocalizacao.getLatitude());
            existingLocalizacao.setLongitude(newLocalizacao.getLongitude());
            return localizacaoRepository.save(existingLocalizacao);
        }).orElse(null);
    }
}

