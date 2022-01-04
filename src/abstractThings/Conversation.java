package abstractThings;

import exceptions.OnlyOnePersonInConversationException;
import interfaces.Conversationable;
import interfaces.MentalHealthable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Conversation {
    private final Set<Conversationable> interlocutors;

    public Conversation(Conversationable... interlocutors) {
        this.interlocutors = new HashSet<>(Arrays.asList(interlocutors));
    }

    public void say(Conversationable teller, String message, Emotion emotion) {
        if (interlocutors.contains(teller)) {
            Set<Conversationable> listeners = new HashSet<>(interlocutors);
            listeners.remove(teller);

            // Нет никакого смысла в диалоге из одного человека
            if (listeners.isEmpty()) {
                throw new OnlyOnePersonInConversationException("Please add more participants to the conversation");
            }

            String listenersNames = "";
            for (Conversationable i : listeners) {
                listenersNames += i.getName() + ", ";
            }
            listenersNames = listenersNames.substring(0, listenersNames.length() - 2);

            Narrator.tell(teller.getName() + " told: \"" + message + "\" to " + listenersNames + ".");

            if (emotion != null) {
                // Каждая сущность из listeners, обладающая ментальным здоровьем, отреагирует на слова teller'а
                for (Conversationable i : listeners) {
                    if (i instanceof MentalHealthable) {
                        System.out.print(i.getName() + ": ");
                        ((MentalHealthable) i).getMentalHealth().reactToSpeech(emotion);
                    }
                }
            }
        } else {
            Narrator.tell(teller.getName() + "was not in the conversation so nobody heard anything");
        }
    }





    public void addMember(Conversationable member) {
        interlocutors.add(member);
        member.setConversation(this);
    }

    public void removeMember(Conversationable member) {
        interlocutors.remove(member);
        member.setConversation(null);
    }

    @Override
    public String toString() {
        return interlocutors.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversation that = (Conversation) o;
        return interlocutors.equals(that.interlocutors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interlocutors);
    }
}