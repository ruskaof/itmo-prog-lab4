import abstractThings.Conversation;
import abstractThings.Emotion;
import abstractThings.MentalHealth;
import abstractThings.Narrator;
import creatures.Human;
import creatures.MagicHat;
import things.WaterWell;
import things.Well;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Well.Pit pit = new Well.Pit(100);
        WaterWell well = new WaterWell(pit);

        Human alice = new Human("Alice", new MentalHealth());
        Human sonya = new Human("Sonya", new MentalHealth());
        MagicHat hat = new MagicHat("Hat");

        Conversation conversation = new Conversation(alice, sonya, hat);

        conversation.say(alice, "Я не понимаю, как же они могли таскать оттуда мармелад?", null);

        conversation.say(hat, "Из обыкновенного колодца таскают воду, а из мармеладного колодца всякий может, " +
                "я надеюсь, таскать мармелад", null);

        conversation.say(alice, "Ты что, совсем дурочка? Я говорю, как они могли таскать мармелад оттуда?" +
                " Ведь они там жили.", null);

        conversation.say(sonya, "Не только жили! Они жили-были!", Emotion.DAZED);

        sonya.yawn();
        sonya.rubEyes();

        conversation.say(sonya, "Так вот, делали что хотели...", Emotion.ANGRY);

        // выдуманная вещь далее:

        // Допустим, в тексте был бы эмоционально стабильный человек (и это был бы единичный случай),
        // тогда его можно объект можно было бы объявить таким образом,
        // используя анонимный класс.
        Human tom = new Human("Thomas", new MentalHealth() {
            @Override
            public void reactToSpeech(Emotion emotion) {
                Narrator.tell("Thomas never cares about teller's intonation so his mood was completely stable");
            }

            ;
        });
    }
}


