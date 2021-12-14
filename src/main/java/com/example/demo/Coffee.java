package com.example.demo;

public class Coffee {
    private String Name;
    private String Type;
    private String Flavor;
    private String Roast;
    private String Quality;
    private int PricePerKg;
    private int Amount;

    public Coffee(){
        Type = "%";
        Flavor = "%";
        Roast = "%";
        Quality = "%";
    }

    public Coffee(String Name, String Type, String Flavor, String Roast, String Quality, int PricePerKg,int Amount){
        this.Name = Name;
        this.Type = Type;
        this.Flavor = Flavor;
        this.Roast = Roast;
        this.Quality = Quality;
        this.PricePerKg = PricePerKg;
        this.Amount = Amount;
    }

    public String getName(){return this.Name;}
    public String getType(){return this.Type;}
    public String getFlavor(){return this.Flavor;}
    public String getRoast(){return this.Roast;}
    public String getQuality(){return this.Quality;}
    public int getPricePerKg(){return this.PricePerKg;}
    public int getAmount(){return this.Amount;}

    public void setName(String Name) {
        this.Name = Name;
    }
    public void setType(String Type) {
        this.Type = Type;
    }
    public void setQuality(String Quality) {
        this.Quality = Quality;
    }
    public void setFlavor(String Flavor) {
        this.Flavor = Flavor;
    }
    public void setRoast(String Roast) {
        this.Roast = Roast;
    }
    public void setPricePerKg(int PricePerKg){this.PricePerKg = PricePerKg;}
    public void setAmount(int Amount){this.Amount = Amount;}
}
