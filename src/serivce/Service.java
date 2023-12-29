package serivce;

import automobil.Automobil;

import java.util.HashMap;
import java.util.Map;

public class Service {

    private Map<Automobil, Integer> automobilMap = new HashMap<>();
    private Map<Automobil, Integer> planReparatie = new HashMap<>();

    public Map<Automobil, Integer> getAutomobilMap(){
        return automobilMap;
    }

    public Map<Automobil, Integer> getPlanReparatie(){
        return planReparatie;
    }
    public void adaugaPlanReparatie(Automobil automobil, int numberVisit){
        planReparatie.put(automobil, numberVisit);
    }

    public void reparaAutomobil(Automobil automobil){
        Integer numberVisit = automobilMap.get(automobil);
        if (numberVisit == null){
            numberVisit = 0;
        }
        numberVisit++;
        automobilMap.put(automobil, numberVisit);

    }
    public void afiseazaFrecventa(){
        automobilMap.entrySet().stream()
                .forEach((a) -> System.out.println(a.getKey().getDenAuto() + " a fost de " + a.getValue() + " ori la service"));
    }


}
