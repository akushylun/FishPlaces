package ua.com.codefire.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
    @NamedQuery(name = "FishInPlaces.findByPlaceId", query = "SELECT f FROM FishInPlace f WHERE f.places = :placeId"),
    @NamedQuery(name = "FishInPlaces.findByFishId", query = "SELECT f FROM FishInPlace f WHERE f.fishes = :fishId")
})

@Entity
@Table(name = "fish_in_places")

public class FishInPlace implements java.io.Serializable {

	private static final long serialVersionUID = -9074035853511013680L;
	
    @Id
    @Column(name = "id", unique = true, nullable = false)
	private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fish_id")
    private Fish fishes;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place places;

    public FishInPlace() {
    }

    public FishInPlace(int id) {
        this.id = id;
    }

    public FishInPlace(Fish fishes, Place places) {
        this.fishes = fishes;
        this.places = places;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fish getFishes() {
        return this.fishes;
    }

    public void setFishes(Fish fishes) {
        this.fishes = fishes;
    }

    public Place getPlaces() {
        return this.places;
    }

    public void setPlaces(Place places) {
        this.places = places;
    }

}
