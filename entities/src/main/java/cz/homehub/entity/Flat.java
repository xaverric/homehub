package cz.homehub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.homehub.api.FlatType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flat")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer number;

    @JsonIgnore
    @OneToMany(mappedBy = "flat")
    private List<User> owners;

    @Column(name = "floor_size")
    private Double floorSize;

    @Column(name = "flat_type")
    private FlatType flatType;

    @Column(name = "house_number")
    private String houseNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<User> getOwners() {
        return owners;
    }

    public void setOwners(List<User> owners) {
        this.owners = owners;
    }

    public Double getFloorSize() {
        return floorSize;
    }

    public void setFloorSize(Double floorSize) {
        this.floorSize = floorSize;
    }

    public FlatType getFlatType() {
        return flatType;
    }

    public void setFlatType(FlatType flatType) {
        this.flatType = flatType;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", number=" + number +
                ", owners=" + owners +
                ", floorSize=" + floorSize +
                ", flatType=" + flatType +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
