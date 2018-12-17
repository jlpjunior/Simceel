package com.simceel.simceelback.dominio.medicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicao")
public class MedicaoController {

    @Autowired
    private MedicaoServico medicaoServico;

    @PostMapping
    public ResponseEntity<?> salvar(@Validated @RequestBody Medicao medicao){
        return
                new ResponseEntity(medicaoServico.salvar(medicao), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> alterar(@Validated @RequestBody Medicao medicao){
        return new ResponseEntity(medicaoServico.salvar(medicao), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{medicaoId}")
    public ResponseEntity<?> excluir(@PathVariable Long medicaoId) {
        return new ResponseEntity(medicaoServico.excluir(medicaoId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return new ResponseEntity(medicaoServico.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{medicaoId}")
    public ResponseEntity<?> findById(@PathVariable Long medicaoId) {
        return new ResponseEntity(medicaoServico.buscarPeloId(medicaoId), HttpStatus.OK);
    }



}
