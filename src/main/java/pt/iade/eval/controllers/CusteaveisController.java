package pt.iade.eval.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.eval.models.Custeavel;
import pt.iade.eval.models.Empregado;
import pt.iade.eval.models.TipoContrato;
import pt.iade.eval.models.repositories.CusteaveisRepository;
import pt.iade.eval.models.results.ResumoCustos;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path="/api/custeaveis")
public class CusteaveisController {
    private Logger logger = LoggerFactory.getLogger(CusteaveisController.class);
    
    @GetMapping(path = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Custeavel> getCusteaveis() {
        logger.info("Enviar todos os custeáveis");
        
        return CusteaveisRepository.getCusteaveis();
    }
   
    @GetMapping(path = "prejuizo", produces= MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Custeavel> getPrejuizos() {
        logger.info("Enviar custeáveis com lucro negativo ");
     
        return CusteaveisRepository.getPrejuizos();
    }
    
    @GetMapping(path = "resumo", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResumoCustos getResumo() {
        logger.info("Enviar resumo de todos os custos");
      
        return CusteaveisRepository.getResumo();
    }
    
    @PutMapping(path = "empregados/producao",produces= MediaType.APPLICATION_JSON_VALUE)
    public Empregado saveEmpregadoProducao(@RequestBody Empregado empregado) {
        logger.info("Adicionar à lista de custos o empregado "+empregado.getDescricao());
        empregado.setContrato(TipoContrato.PRODUCAO);
        CusteaveisRepository.saveEmpregado(empregado);
        return empregado;
    }
    
}
