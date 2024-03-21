package EventManagement;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("exposition")
public class Exposition extends Event {
}
