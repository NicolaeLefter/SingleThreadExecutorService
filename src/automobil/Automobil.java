package automobil;

public class Automobil {

    private String denAuto;
    private int age;

    public Automobil(String denAuto, int age){
        this.denAuto = denAuto;
        this.age = age;
    }

    public String getDenAuto(){
        return denAuto;
    }
    public int getAge(){
        return age;
    }
}
