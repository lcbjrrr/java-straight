public class Guy {
    private String name;
    private float cash;
    Guy(String n,float c) {
        this.name=n;
        this.cash=c;
    }
    void takeCash(float v) {
        this.cash=this.cash+v;
    }
    boolean giveCash(float v) {
        if(v<this.cash) {
            this.cash=this.cash-v;
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) {
        Guy john=new Guy("John",100);
        Guy mary=new Guy("Mary",900);
        float value = 50;
        if(john.giveCash(value)){
            mary.takeCash(value);
        }
        System.out.println(john.getName()+" $ "+john.getCash());
        System.out.println(mary.getName()+" $ "+mary.getCash());
    }
    public float getCash() {
        return cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
