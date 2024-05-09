package Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name="zone")
@Data
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int zoneCode;
    private String zoneName;
    private int zoneStatus;
}
