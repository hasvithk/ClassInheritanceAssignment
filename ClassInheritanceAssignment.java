/**
 *
 * @author hkadagala2024
 */
public class ClassInheritanceAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Car class
        FlyingCar fc = new FlyingCar("Aeromobil", 500.00, 2, 500, 15.0, 2);
        System.out.println(fc);
        UnderwaterCar wc = new UnderwaterCar("sQuba", 80.00, 4, 200, 30, 2, 4);
        System.out.println(wc);
        //Boat class
        Submarine sb = new Submarine("Triton", 33, 64, 16764, 1, 1, 4, 1, 10 );
        System.out.println(sb);
        FishingVessel fv = new FishingVessel("Boston Whaler", 60, 50, 15, 1, 1, 2, 2);
        System.out.println(fv);
        //Airplane class
        Jet jt = new Jet("Lockheed P - 38", 500, 2, 118000, 2, 1, 3);
        System.out.println(jt);
        Helicopter hc = new Helicopter("Bell CH-146 Griffon", 130, 8, 4000, 0, 1, 4);
        System.out.println(hc);
        //2 other vehicles
        Robot rb = new Robot("Fanuc", 150, 150, 5000, 8, 2, 10);
        System.out.println(rb);
        Spacecraft sc = new Spacecraft("Gemini", 17500, 7, 50000, 2, 1, 3);
        System.out.println(sc);
        
    }
    
}

// The Base Vehicle Class, implements the Speedometer interface
class Vehicle implements Speedometer{
    //base (Class wide) variables
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    protected double cargoWeight = 0.0;
    //Base default constructor 
    public Vehicle(){
        brandName = "";
        speed = 0.0;
        passengers = 0;
        cargoWeight = 0.0;
    }

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo){
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    //getters and setters
    public Vehicle(String inBrand){
        brandName = inBrand;
    }

    public String getBrand(){
        return brandName;
    }

    public  void setBrandName(String inBrand){
        brandName = inBrand;
    }

    public double getSpeed(){
        return  speed;
    }

    public void setSpeed(double inSpeed){
        speed = inSpeed;
    }

    public int getPassengers(){
        return  passengers;
    }

    public void setPassengers(int inPassengers){
        speed = inPassengers;
    }

    public double getCargoWeight(){
        return  cargoWeight;
    }

    public void setCargoWeight(double inCargoWeight){
        cargoWeight = inCargoWeight;
    }

    //Base toString
    public String toString(){
        String result = "";
        result = "Brand: \t\t" + getBrand() + "\n" +
                "Speed (mph): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n";
        return result;
    }
}
//the Speedometer interface to show the speed of any vehicle in the same way
interface Speedometer{
    public void setSpeed(double inSpeed);
    public double getSpeed();
 }


// Car Class inherits from Vehicle Class
class Car extends Vehicle{
    int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg

    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setSpoiler(boolean inSpoiler){
        spoiler = inSpoiler;
    }

    public boolean getSpoiler(){
        return spoiler;
    }
    //another additional variable
    public void setStereo(boolean inStereo){
        stereo = inStereo;
    }

    public boolean getStereo(){
        return  stereo;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "MPG :\t\t" + this.getMPG() + "\n";
        return  result ;
    }
}

class FlyingCar extends Car{
    int wings = 2;
    public FlyingCar (String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG, int inWings){
        super (inBrand, inSpeed, inPassengers, inCargo, inMPG);
        wings = inWings;
    }
    
    //get setters and getters
    public int getWings(){
        return wings;
    }
    
    public void setWings(int inWings){
        wings = inWings;
    }
    
    //toString
    public String toString(){
        String result = "Brand: \t\t"+getBrand() + "\n" +
                "Speed (knots): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n" +
                "Wings: \t\t" + getWings() + "\n";
        return result;          
    }
}


class UnderwaterCar extends Car{
    int propellers = 2;
    int oxygenMask = 4;
    public UnderwaterCar (String inBrand, double inSpeed, int inPassengers, double inCargo, int inMPG, int inPropellers, int inOxygenMask){
        super (inBrand, inSpeed, inPassengers, inCargo,inMPG);
        propellers = inPropellers;
        oxygenMask = inOxygenMask;
        
    }

    //get setters and getters
    public int getPropellers(){
        return propellers;
    }

    public void setPropeller(int inPropellers){
        propellers = inPropellers;
    }
    
    public int getOxygenMask(){
        return oxygenMask;
    }

    public void setOxygenMask(int inOxygenMask){
        oxygenMask = inOxygenMask;
    }

    //toString
    public String toString(){
        String result = super.toString() +
                "Propellers: \t" + getPropellers() + "\n" +
                "Oxygen Mask: \t" + getOxygenMask() + "\n";
        return result;          
    }

}

class Boat extends Vehicle{
    int engine = 1;
    int propeller = 2;
    public Boat(String inBrand, double inSpeed, int inPassengers, double inCargo,int inEngine, int inPropeller){
        super(inBrand, inSpeed, inPassengers, inCargo);
        engine = inEngine;
        propeller = inPropeller;
    }
    
    //set setters and getters
    public int getEngine(){
        return engine;
    }

    public void setEngine(int inEngine){
        engine = inEngine;
    }
    
    public int getPropeller(){
        return propeller;
    }

    public void setPropeller(int inPropeller){
        propeller = inPropeller;
    }
    
    //toString
    public String toString(){
        String result = "Brand: \t\t"+getBrand() + "\n" +
                "Speed (knots): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (ton): \t" + getCargoWeight() + "\n" +
                "Engine: \t" + getEngine() + "\n" + 
                "Propeller: \t" + getPropeller() + "\n";
                
        return result;          
    }
    
}

class Submarine extends Boat{
    int radar = 4;
    int hatch = 1;
    int missile = 10;
    public Submarine(String inBrand, double inSpeed, int inPassengers, double inCargo, int inEngine, int inPropeller, int inRadar, int inHatch, int inMissile) {
        super(inBrand, inSpeed, inPassengers, inCargo, inEngine, inPropeller);
        radar = inRadar;
        hatch = inHatch;
        missile = inMissile;
    }
    
    //set setters and getters
    public int getRadar(){
        return radar;
    }

    public void setRadar(int inRadar){
        radar = inRadar;
    }
    
    public int getHatch(){
        return hatch;
    }

    public void setHatch(int inHatch){
        hatch = inHatch;
    }
    
    public int getMissile(){
        return missile;
    }

    public void setMissile(int inMissile){
        missile = inMissile;
    }
    
    //toString
    public String toString(){
        String result = super.toString() +
                "Radar: \t\t" + getRadar() + "\n" + 
                "Hatch: \t\t" + getHatch() + "\n" +
                "Missile: \t" + getMissile() + "\n";
                               
        return result;          
    }
    
}


class FishingVessel extends Boat{
    int fishingNet = 2;
    int anchor = 2;
    public FishingVessel(String inBrand, double inSpeed, int inPassengers, double inCargo, int inEngine, int inPropeller, int inFishingNet, int inAnchor){
        super(inBrand, inSpeed, inPassengers, inCargo, inEngine, inPropeller);
        fishingNet = inFishingNet;
        anchor = inAnchor;
    }
    
    //set setters and getters
    public int getFishingNet(){
        return fishingNet;
    }

    public void setFishingNet(int inFishingNet){
        fishingNet = inFishingNet;
    }
    
    public int getAnchor(){
        return anchor;
    }

    public void setAnchor(int inAnchor){
        anchor = inAnchor;
    }
    
    //toString
    public String toString(){
        String result = super.toString() +
                "FishingNet : \t" + getFishingNet() + "\n" + 
                "Anchor: \t" + getAnchor() + "\n";
                               
        return result;          
    }
    
}

class Airplane extends Vehicle{
int wing = 2;
int engine = 1;
public Airplane(String inBrand, double inSpeed, int inPassengers, double inCargo, int inWing, int inEngine){
        super(inBrand, inSpeed, inPassengers, inCargo);
        wing = inWing;
        engine = inEngine;
    }

    //set setters and getters
    public int getWing(){
        return wing;
    }

    public void setWing(int inWing){
        wing = inWing;
    }
    
    public int getEngine(){
        return engine;
    }

    public void setEngine(int inEngine){
        engine = inEngine;
    }
    
    //toString
    public String toString(){
        String result = "Brand: \t\t"+getBrand() + "\n" +
                "Speed (knots): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n" +
                "Wing : \t\t" + getWing() + "\n" + 
                "Engine: \t" + getEngine() + "\n";
                               
        return result;   
    }
}

class Jet extends Airplane{
int missile;
public Jet(String inBrand, double inSpeed, int inPassengers, double inCargo, int inWing, int inEngine, int inMissile){
    super(inBrand, inSpeed, inPassengers, inCargo, inWing, inEngine);
    missile = inMissile;
}
    //set setters and getters
    public int getMissile(){
        return missile;
    }

    public void setMissile(int inMissile){
        missile = inMissile;
    }
    
    //toString
    public String toString(){
        String result = super.toString() +
                "Missile: \t" + getMissile() + "\n";
                               
        return result;  
    
}
}

class Helicopter extends Airplane{
int blade = 4;
    public Helicopter(String inBrand, double inSpeed, int inPassengers, double inCargo, int inWing, int inEngine, int inBlade){
    super(inBrand, inSpeed, inPassengers, inCargo, inWing, inEngine);
    blade = inBlade;
}
    //set setters and getters
    public int getBlade(){
        return blade;
    }

    public void setBlade(int inBlade){
        blade = inBlade;
    }
    
    //toString
    public String toString(){
        String result = super.toString() +
                "Blade: \t\t" + getBlade() + "\n";
                               
        return result;  
}
    
}

class Robot extends Vehicle{
int leg = 8;
int arm = 2;
int motor = 10; 
    public Robot(String inBrand, double inSpeed, int inPassengers, double inCargo, int inLeg, int inArm, int inMotor){
        super(inBrand, inSpeed, inPassengers, inCargo);
    leg = inLeg;
    arm = inArm;
    motor = inMotor;
}
    //set setters and getters
    public int getLeg(){
        return leg;
    }

    public void setLeg(int inLeg){
        leg = inLeg;
    }
    public int getArm(){
        return arm;
    }

    public void setArm(int inArm){
        arm = inArm;
    }
    
    public int getMotor(){
        return motor;
    }

    public void setMotor(int inMotor){
        motor = inMotor;
    }
    
    //toString
    public String toString(){
        String result = super.toString() +
                "Leg: \t\t" + getLeg() + "\n" +
                "Arm: \t\t" + getArm() + "\n"+
                "Motor: \t\t" + getMotor() + "\n";
       
                               
        return result;
}
    
}

class Spacecraft extends Vehicle{
int externalTank = 1;
int oxygenTank = 1;
int engine = 1;
    public Spacecraft(String inBrand, double inSpeed, int inPassengers, double inCargo, int inExternalTank, int inOxygenTank, int inEngine){
        super(inBrand, inSpeed, inPassengers, inCargo);
externalTank = inExternalTank;
oxygenTank = inOxygenTank;
engine = inEngine;
}
//set setters and getters
    public int getExternalTank(){
        return externalTank;
    }

    public void setExternalTank(int inExternalTank){
        externalTank = inExternalTank;
    }
    public int getOxygenTank(){
        return oxygenTank;
    }

    public void setOxygenTank(int inoxygenTank){
        oxygenTank = inoxygenTank;
    }
    
    public int getEngine(){
        return engine;
    }

    public void setEngine(int inEngine){
        engine = inEngine;
    }
    
    //toString
    public String toString(){
        String result = super.toString() +
                "Leg: \t\t" + getExternalTank() + "\n" +
                "Arm: \t\t" + getOxygenTank() + "\n"+
                "Motor: \t\t" + getEngine();
                               
        return result;
}
}


