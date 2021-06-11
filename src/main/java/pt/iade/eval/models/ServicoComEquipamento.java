package pt.iade.eval.models;

import java.util.ArrayList;

public class ServicoComEquipamento extends Servico {
    private ArrayList<Equipamento> equipamentos;

    public ServicoComEquipamento(String descricao, double valor, 
                     double roi, ArrayList<Equipamento> equipamentos) {
        super(descricao, valor, roi);
        this.equipamentos = equipamentos;
    }

    @Override
    public double getCusto() {
        double custo = super.getCusto();
        for (Equipamento equipamento : equipamentos) {
            custo += equipamento.getValor();
        }
        return custo;
    }

    @Override
    public String getDescricao() {
        String desc = super.getDescricao()+"\n";
        desc += "Equipamentos adquiridos:\n";
        for (Equipamento equipamento : equipamentos) {
            desc += equipamento.toString()+"\n";
        }
        return desc; 
    }

}
