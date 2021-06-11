package pt.iade.eval.models.repositories;

import java.util.ArrayList;
import java.util.List;

import pt.iade.eval.models.Custeavel;
import pt.iade.eval.models.Empregado;
import pt.iade.eval.models.Equipamento;
import pt.iade.eval.models.Servico;
import pt.iade.eval.models.ServicoComEquipamento;
import pt.iade.eval.models.TipoContrato;
import pt.iade.eval.models.results.ResumoCustos;

public class CusteaveisRepository {
    private static ArrayList<Custeavel> custeaveis = new ArrayList<>();
    public static void populate() {
        Empregado e1 = new Empregado(800,"Manuel Silva",TipoContrato.PRODUCAO);
        custeaveis.add(e1);
        Empregado e2 = new Empregado (1500,"Maria Pereira",TipoContrato.ADMINISTRADOR);
        e2.setReceita(50000);
        custeaveis.add(e2);
        Servico s1 = new Servico("Aplicação para presenças",100000,1.5);
        custeaveis.add(s1);
        ArrayList<Equipamento> eqs1 = new ArrayList<>();
        Equipamento eq1 = new Equipamento("Cabalagem", 20000);
        Equipamento eq2 = new Equipamento("Rack com switches", 50000);
        eqs1.add(eq1);
        eqs1.add(eq2);
        custeaveis.add(new ServicoComEquipamento("Instalação de rede a 10Gbps",
                 80000, 0.7, eqs1));
        ArrayList<Equipamento> eqs2 = new ArrayList<>();
        eqs2.add(new Equipamento("Servidor",5000));
        custeaveis.add(new ServicoComEquipamento("Compra de Servidor",
                        0, 5, eqs2));
    }
 
    public static ArrayList<Custeavel> getCusteaveis() {
        return custeaveis;
    }   

    public static ArrayList<Custeavel> getPrejuizos() {
        ArrayList<Custeavel> prejuizos = new ArrayList<>();
        for (Custeavel custeavel : custeaveis) {
            if (custeavel.getLucro() < 0) prejuizos.add(custeavel);
        }
        return prejuizos;
    }   

    public static void saveEmpregado(Empregado emp) {
        custeaveis.add(emp);
    }

    public static ResumoCustos getResumo() {
        double custo = 0;
        double receita = 0;
        double lucro = 0;
        for (Custeavel custeavel : custeaveis) {
            custo+=custeavel.getCusto();
            receita+=custeavel.getReceita();
            lucro+=custeavel.getLucro();
        }
        return new ResumoCustos(custo,receita,lucro);
    }

}