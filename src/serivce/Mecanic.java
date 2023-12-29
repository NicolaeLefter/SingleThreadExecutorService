package serivce;

import automobil.Automobil;

import java.util.Set;
import java.util.concurrent.Callable;

public class Mecanic  implements Callable<Integer> {

    private Automobil automobil;
    private Service service;
    public Mecanic(Automobil automobil, Service service){
        this.automobil = automobil;
        this.service = service;
    }



    @Override
    public Integer call() throws Exception {

        service.reparaAutomobil(automobil);
        return 1000;
    }
}
