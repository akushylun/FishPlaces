package ua.com.codefire.dao.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(name = "Fishes.findAll", query = "SELECT f FROM Fish f"),
    @NamedQuery(name = "Fishes.findByFishId", query = "SELECT f FROM Fish f WHERE f.fishId = :fishId"),
    @NamedQuery(name = "Fishes.findByFishName", query = "SELECT f FROM Fish f WHERE f.fishName = :fishName")})
@Entity
@Table(name = "fishes")
public class Fish implements java.io.Serializable {
	
	private static final long serialVersionUID = 6516204211145359152L;

	@Id
    @Column(name = "fish_id", unique = true, nullable = false)
    private int fishId;
	
	@Column(name = "fish_name")
    private String fishName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fishes")
    private Set<FishInPlace> fishInPlaceses = new HashSet<>(0);

    public Fish() {
    }

    public Fish(int fishId) {
        this.fishId = fishId;
    }

    public Fish(String fishName, Set<FishInPlace> fishInPlaces) {
        this.fishName = fishName;
        this.fishInPlaceses = fishInPlaces;
    }

    public int getFishId() {
        return this.fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public String getFishName() {
        return this.fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public Set<FishInPlace> getFishInPlaceses() {
        return this.fishInPlaceses;
    }

    public void setFishInPlaceses(Set<FishInPlace> fishInPlaceses) {
        this.fishInPlaceses = fishInPlaceses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.fishId;
        hash = 13 * hash + Objects.hashCode(this.fishName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fish other = (Fish) obj;
        if (this.fishId != other.fishId) {
            return false;
        }
        if (!Objects.equals(this.fishName, other.fishName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fish{" + "fishId=" + fishId + ", fishName=" + fishName + '}';
    }

}
