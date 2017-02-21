package ua.com.codefire.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(name = "Places.findAll", query = "SELECT p FROM Place p"),
    @NamedQuery(name = "Places.findByPlaceId", query = "SELECT p FROM Place p WHERE p.placeId = :placeId"),
    @NamedQuery(name = "Places.findByPlaceName", query = "SELECT p FROM Place p WHERE p.placeName = :placeName"),
    @NamedQuery(name = "Places.findByPlaceGeoLat", query = "SELECT p FROM Place p WHERE p.placeGeoLat = :placeGeoLat"),
    @NamedQuery(name = "Places.findByPlaceGeoLong", query = "SELECT p FROM Place p WHERE p.placeGeoLong = :placeGeoLong")})
@Entity
@Table(name = "places")
public class Place implements java.io.Serializable {

	private static final long serialVersionUID = -7715738452810113157L;
	
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "place_id", unique = true, nullable = false)
	private Integer placeId;
    
    @Column(name = "place_name")
    private String placeName;
    
    @Column(name = "place_geo_lat", nullable = false, precision = 255)
    private float placeGeoLat;
    
    @Column(name = "place_geo_long", nullable = false, precision = 255)
    private float placeGeoLong;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "places")
    private Set<FishInPlace> fishInPlaceses = new HashSet<>(0);

    public Place() {
    }

    public Place(float placeGeoLat, float placeGeoLong) {
        this.placeGeoLat = placeGeoLat;
        this.placeGeoLong = placeGeoLong;
    }

    public Place(String placeName, float placeGeoLat, float placeGeoLong, Set<FishInPlace> fishInPlaceses) {
        this.placeName = placeName;
        this.placeGeoLat = placeGeoLat;
        this.placeGeoLong = placeGeoLong;
        this.fishInPlaceses = fishInPlaceses;
    }

    public Integer getPlaceId() {
        return this.placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public float getPlaceGeoLat() {
        return this.placeGeoLat;
    }

    public void setPlaceGeoLat(float placeGeoLat) {
        this.placeGeoLat = placeGeoLat;
    }

    public float getPlaceGeoLong() {
        return this.placeGeoLong;
    }

    public void setPlaceGeoLong(float placeGeoLong) {
        this.placeGeoLong = placeGeoLong;
    }

    public Set<FishInPlace> getFishInPlaceses() {
        return this.fishInPlaceses;
    }

    public void setFishInPlaceses(Set<FishInPlace> fishInPlaceses) {
        this.fishInPlaceses = fishInPlaceses;
    }

}
