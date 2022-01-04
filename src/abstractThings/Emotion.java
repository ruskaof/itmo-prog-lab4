package abstractThings;

public enum Emotion {
    AFRAID("afraid"),
    AMAZED("amazed"),
    ANGRY("angry"),
    ANXIOUS("anxious"),
    CURIOUS("curious"),
    DAZED("dazed"),
    FEARFUL("fearful"),
    GLAD("glad"),
    NORMAL("normal"),
    WORRIED("worried"),
    VERY_BAD("very bad");

    Emotion(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
