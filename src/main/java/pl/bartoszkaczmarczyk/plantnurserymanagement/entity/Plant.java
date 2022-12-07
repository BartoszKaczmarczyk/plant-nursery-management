package pl.bartoszkaczmarczyk.plantnurserymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Size cannot be blank")
    private String size;

    @Positive
    private double price;

    private int stock;

    @JsonIgnore
    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL)
    private List<Supply> supplies;

    public Plant() {
        this.stock = 0;
    }

    public Plant(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.stock = 0;
    }
}
