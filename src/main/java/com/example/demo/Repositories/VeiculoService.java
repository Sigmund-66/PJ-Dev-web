package com.example.demo.Repositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> getVeiculoById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo saveVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }
}
