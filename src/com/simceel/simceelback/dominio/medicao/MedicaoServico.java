package com.simceel.simceelback.dominio.medicao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicaoServico {

    @Autowired
    private MedicaoRepository medicaoRepository;


    public Medicao salvar(Medicao medicao){
        return medicaoRepository.save(medicao);
    }

    public boolean excluir(Long medicaoId){
        Medicao medicaoBusca = medicaoRepository.getOne(medicaoId);
        if( medicaoBusca != null ){
            medicaoRepository.delete(medicaoBusca);
            return true;
        }
        else {
            return false;
        }
    }

    public Medicao buscarPeloId(Long medicaoId){
        return medicaoRepository.getOne(medicaoId);
    }

    public List<Medicao> buscarTodos(){
        return medicaoRepository.findAll();
    }

}
