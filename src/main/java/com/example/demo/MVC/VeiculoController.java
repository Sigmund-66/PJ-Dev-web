package com.example.demo.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.getVeiculoById(id);
        return veiculo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Veiculo> saveVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoService.saveVeiculo(veiculo);
        return new ResponseEntity<>(savedVeiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo updatedVeiculo = veiculoService.updateVeiculo(id, veiculo);
        
        if (updatedVeiculo != null) {
            // Veículo atualizado com sucesso
            return new ResponseEntity<>(updatedVeiculo, HttpStatus.OK);
        } else {
            // Veículo não encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        veiculoService.deleteVeiculo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
