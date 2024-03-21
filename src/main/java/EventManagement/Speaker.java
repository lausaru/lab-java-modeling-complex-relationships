package EventManagement;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int speakerId;
    private String name;
    private double presentationDuration;
    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    public Speaker() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speaker speaker = (Speaker) o;
        return Double.compare(presentationDuration, speaker.presentationDuration) == 0 && Objects.equals(name, speaker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, presentationDuration);
    }
}
