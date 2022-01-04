package abstractThings;

import java.util.Objects;

public class MentalHealth {
    protected Emotion emotion = Emotion.NORMAL;

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Emotion getEmotion() {
        return emotion;
    }


    public void reactToSpeech(Emotion emotion) {
        if (emotion != Emotion.NORMAL) {
            setEmotion(emotion);
            Narrator.tell("is now " + emotion.getValue() + " because of these words");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentalHealth that = (MentalHealth) o;
        return emotion == that.emotion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(emotion);
    }

    @Override
    public String toString() {
        return "MentalHealth{" +
                "emotion=" + emotion +
                '}';
    }
}