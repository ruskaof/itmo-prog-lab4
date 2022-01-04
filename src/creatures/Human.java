package creatures;

import abstractThings.Emotion;
import abstractThings.MentalHealth;
import abstractThings.Narrator;
import interfaces.MentalHealthable;

import java.util.Objects;


public class Human extends IntelligentCreature implements MentalHealthable {

    protected final MentalHealth mentalHealth;
    protected final Heart heart;

    public Human(String name, MentalHealth mentalHealth) {
        super(name);
        this.mentalHealth = mentalHealth;
        this.heart = new Heart();
    }

    protected class Heart {
        public void hurt() { getMentalHealth().setEmotion(Emotion.WORRIED); }
    }

    public void yawn() {
        Narrator.tell(getName() + " yawns");
    }

    public void rubEyes() {
        Narrator.tell(getName() + " rubs eyes");
    }


    @Override
    public MentalHealth getMentalHealth() {
        return this.mentalHealth;
    }

    @Override
    public String toString() {
        return "Human{" +
                "mentalHealth=" + mentalHealth + ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return mentalHealth.equals(human.mentalHealth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentalHealth, name);
    }
}
