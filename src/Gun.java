import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Gun {
    private static ArrayList<Gun> list = new ArrayList<Gun>();  //regular array but holds class data types
    //static means belong to the whole class
    private String model; // instance variable
    private float ammo; //instance variable
    private boolean safetyLock; //instance variable
    private boolean loaded; // instance variable
    private int magazineSize; // instance variable
    private String weaponType; // instance variable

    public Gun(String model, float ammo, boolean safetyLock, boolean loaded, int magazineSize, String weaponType) {
        //constructor has the same name as the class and no return type, refer to setLoaded for differences
        this.model = model;  //points to instance variable
        this.ammo = ammo;
        this.safetyLock = safetyLock;
        this.loaded = loaded;
        this.magazineSize = magazineSize;
        this.weaponType = weaponType;
    }

    public Gun(String model) {
        //this is the signature for this constructor (String model)
        this(model, 0, false, false, 0, "");
        // calling the other Gun constructor with the Parameters due to signature matching
    }

    public String getModel() {      //Creating setters and getter is called encapsulation
        return model;
    }

    public boolean getLoaded() {    //getter
        return loaded;
    }

    public float getAmmo() {
        return ammo;
    }

    public void setLoaded(boolean value) {    //void doesn't have return statement (setter)
        //method have return type "void", name "setLoaded", parameter"(boolean value)"
        loaded = value;
    }

    public static void searchCaliber(float ammoType) {
        for (Gun g : list) {
            if (g.getAmmo() == ammoType)                     //enhanced for loop
                System.out.println(g.getModel());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //creates scanner that reads keyboard input
        Gun glock = new Gun("ACP", .45f, false, false, 15, "Hand Gun");
        // new gun is instantiating the glock
        list.add(glock);
        System.out.println("This is the gun model " + glock.getModel());
        Gun ruger = new Gun("SR40 Compact", .40f, true, true, 15, "Hand Gun");
        list.add(ruger);
        System.out.println("This is the gun model " + ruger.getModel());
        Gun ar15 = new Gun("AR15", 5.56f, true, false, 30, "Rifle");
        list.add(ar15);
        System.out.println("This is the gun model " + ar15.getModel());
        System.out.println("This is before the ar15.setLoaded setter " + ar15.getLoaded());
        ar15.setLoaded(true); //setter sets it to whatever is in the ()
        System.out.println("This is after the ar15.setLoaded setter " + ar15.getLoaded());
        System.out.println("Enter Caliber to search ");
        //do while
        searchCaliber(sc.nextFloat());
        sc.nextLine();
        Gun shotgun = new Gun("12 Guage"); //overloaded constructor
        Gun ak47 = new Gun("Ak47", 7.62f, true, false, 30, "Rifle");

        Gun[] myGuns = {glock, ruger, ar15, shotgun, ak47};
        //this is an array


        while (true) {
            System.out.println("\n 1 caliber 2 trigger lock 3 model \n" + "4 gun magazine 5 exit ");
            String gun = sc.nextLine();
            switch (gun) {
                case "1":
                case "caliber":
                    System.out.println("Insert Caliber to search  ");
                    searchCaliber(sc.nextFloat());
                    sc.nextLine();
                    break;
                case "2":
                case "trigger lock":
                    System.out.println("Guns with safety locks");
                    for (int s = 0; s < myGuns.length; s++) {
                        if (myGuns[s].safetyLock)
                            System.out.println(myGuns[s].getModel());
                    }
                    break;
                case "3":
                case "model": //sequential search or linear search
                    System.out.println("please enter gun model ");
                    String name = sc.nextLine();
                    for (int m = 0; m < myGuns.length; m++) {
                        if (myGuns[m].model.equals(name)) //.equals for strings but for int is ==
                            System.out.println(myGuns[m].weaponType);
                    }
                    break;
                case "4":
                case "gun magazine":
                    System.out.println("Please enter magazine size  ");
                    int ammo = sc.nextInt();
                    sc.nextLine();
                    for (int a = 0; a < myGuns.length; a++) {
                        if (myGuns[a].magazineSize == ammo)
                            System.out.println(myGuns[a].model);
                    }
                    break;
                case "5":
                case "exit":
                    return;


            }
        }
    }
}



