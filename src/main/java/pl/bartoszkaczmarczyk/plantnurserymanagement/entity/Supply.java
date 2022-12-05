package pl.bartoszkaczmarczyk.plantnurserymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "supply", uniqueConstraints = {@UniqueConstraint(columnNames = {"plant_id", "supplier_id"})})
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Positive(message = "Quantity cannot be negative")
    private Long quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plant_id", referencedColumnName = "id")
    private Plant plant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;
}
