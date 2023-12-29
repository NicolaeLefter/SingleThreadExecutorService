import automobil.Automobil;
import serivce.Mecanic;
import serivce.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Automobil automobil = new Automobil("BMW", 2020);
        Automobil automobil1 = new Automobil("VW", 2018);
        Automobil automobil2 = new Automobil("OPEL", 2000);

        List<Automobil> automobilList = new ArrayList<>();
        automobilList.add(automobil);
        automobilList.add(automobil1);
        automobilList.add(automobil2);

        Service service = new Service();
        service.adaugaPlanReparatie(automobil, 3);
        service.adaugaPlanReparatie(automobil1, 2);
        service.adaugaPlanReparatie(automobil2, 1);

       ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        for (Automobil auto : automobilList ){
            int number = service.getPlanReparatie().get(auto);
            int timpAsteptare = 1500;

            for (int i = 0; i < number; i++) {
                ScheduledFuture<Integer> future = executorService.schedule(new Mecanic(auto, service), number, TimeUnit.MILLISECONDS);
                timpAsteptare = future.get();
            }
        }
        try {
            Thread.sleep(4000);
        }catch(InterruptedException e){
            throw  new RuntimeException(e);
        }

        service.afiseazaFrecventa();
        executorService.shutdown();
    }
}
