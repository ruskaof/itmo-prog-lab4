package exceptions;

public class OnlyOnePersonInConversationException extends RuntimeException{

    public OnlyOnePersonInConversationException(String message){
        super(message);
    }

}
