package com.example.demo.MVC;
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

    public Veiculo updateVeiculo(Long id, Veiculo veiculo) {
        // Verificar se o veículo com o ID fornecido existe
        Optional<Veiculo> existingVeiculoOptional = veiculoRepository.findById(id);
        
        if (existingVeiculoOptional.isPresent()) {
            // Veículo encontrado, atualizar os dados
            Veiculo existingVeiculo = existingVeiculoOptional.get();
            existingVeiculo.setPlaca(veiculo.getPlaca());
            existingVeiculo.setModelo(veiculo.getModelo());
            existingVeiculo.setAnoFabricacao(veiculo.getAnoFabricacao());

            // Salvar e retornar o veículo atualizado
            return veiculoRepository.save(existingVeiculo);
        } else {
            
            return null;
        }
    }
}
