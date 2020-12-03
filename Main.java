import java.util.Scanner;

public class Main {
// https://github.com/Khwaja-Bilkhis/KBCode.git



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double reqKM=scanner.nextDouble();
        if(reqKM<0) {
            System.out.println("Invalid Input!");
            return;
        }
// Car is a class and mini,sedan,suv are objects of class car;
        Car mini=new Car(50, 3, 10, 8, 75);
        Car sedan=new Car(80, 5, 12, 10, 100);
        Car suv=new Car(100, 5, 15, 12, Integer.MAX_VALUE);
        System.out.print("Mini-Rs."+(int)mini.estimatedCost(reqKM));
        System.out.print(", Sedan-Rs."+(int)sedan.estimatedCost(reqKM));
        System.out.print(", SUV-Rs."+(int)suv.estimatedCost(reqKM));
    }
}

class Car{
    double baseRs;
    double basekm;
    double next15km;
    double addRs;
    double maxLimitkm;
    Car(double a,double b,double c,double d,double e){
        baseRs=a;
        basekm=b;
        next15km=c;
        addRs=d;
        maxLimitkm=e;
    }
    double estimatedCost(double givenKm){
        if(givenKm>maxLimitkm){
            return givenKm*addRs;
        }else if(givenKm>15){
            return baseRs+15*next15km+(givenKm-15-basekm)*addRs;
        }else if(givenKm>basekm){
            return baseRs+(givenKm-basekm)*next15km;
        }else {
            return baseRs;
        }
    }
}