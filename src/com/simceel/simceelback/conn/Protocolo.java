/*
 * Comunicação Serial Java Arduino.
 * By Leonardo Godoi.
 */
package com.simceel.simceelback.conn;

import com.simceel.simceelback.dominio.medicao.Medicao;
import com.simceel.simceelback.dominio.medicao.MedicaoServico;
import org.springframework.beans.factory.annotation.Autowired;

public class Protocolo {

    @Autowired
    MedicaoServico medicaoServico;

    private String tipoDado;
    private String kwhTotal;
    private String vlreais;
   
    private String leituraComando;
    
    private void interpretaComando(){
        //Separa uma String de Comando em substrings delimitadas por um sinal separador específico.
        String aux[] = leituraComando.split(",");
        if(aux.length == 2){
            kwhTotal = aux[3];
            vlreais = aux [4];      
        }
    }

    public String getTipoDado() {
        return tipoDado;
    }

    public void setTipoDado(String tipoDado) {
        this.tipoDado = tipoDado;
    }
    
    public String getPotenciatotal() {
        return kwhTotal;
    }

    public void setPotenciatotal(String kwhTotal) {
        this.kwhTotal = kwhTotal;
    }

    public String getCustoreal() {
        return vlreais;
    }

    public void setCustoreal(String vlreais) {
        this.vlreais = vlreais;
    }

    public String getLeituraComando() {
        return leituraComando;
    }

    public void setLeituraComando(String leituraComando) {
        this.leituraComando = leituraComando; //Obtemos a String de dados.
        this.interpretaComando(); //Interpretamos a String de dados.

        Medicao medicao = new Medicao();
        medicao.setPot_Medida(this.kwhTotal);
        medicao.setCusto(Float.parseFloat(this.vlreais));

        this.medicaoServico.salvar(medicao);
    }
    
}
