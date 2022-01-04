package creatures;

import abstractThings.Conversation;
import interfaces.Conversationable;

public abstract class IntelligentCreature extends AliveCreature implements Conversationable {

    protected Conversation conversation;

    IntelligentCreature(String name){
        super(name);
    }

    @Override
    public Conversation getConversation(){
        return this.conversation;
    }

    @Override
    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
