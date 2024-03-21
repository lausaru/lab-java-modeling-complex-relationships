package EventManagement;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="event_type", discriminatorType = DiscriminatorType.STRING)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private Date date;
    private double duration;
    private String location;
    private String title;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guest> guestList; // list of guests that are invited to the event

    public Event() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(duration, event.duration) == 0 && Objects.equals(date, event.date) && Objects.equals(location, event.location) && Objects.equals(title, event.title) && Objects.equals(guestList, event.guestList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, duration, location, title, guestList);
    }
}
