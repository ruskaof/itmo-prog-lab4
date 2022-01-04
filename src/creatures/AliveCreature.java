package creatures;

public abstract class AliveCreature {
    final protected String name;
    AliveCreature(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
