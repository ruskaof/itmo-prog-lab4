package interfaces;

import abstractThings.Conversation;

public interface Conversationable {
    public Conversation getConversation();
    public void setConversation(Conversation conversation);
    public String getName();
}
