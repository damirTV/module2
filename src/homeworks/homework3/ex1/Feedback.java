package homeworks.homework3.ex1;

import java.time.LocalDateTime;

public class Feedback {
    private int id;
    private String text;
    private Integer likes;
    private LocalDateTime dateTime;

    public Feedback(int id, String text, Integer likes) {
        this.id = id;
        this.text = text;
        this.likes = likes;
        this.dateTime = LocalDateTime.now();
    }

    public Integer getLikes() {
        return likes;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Feedback feedback = (Feedback) object;
        return id == feedback.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
