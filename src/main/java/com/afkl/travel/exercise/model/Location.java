package com.afkl.travel.exercise.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Location")
@Table(name = "Location")
public class Location {	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
	List<Translation> translations;

	String code;
	String type;
	Double longitude;
	Double latitude;

	public Location() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", code=" + code + ", type=" + type + ", longitude=" + longitude + ", latitude="
				+ latitude + ", translations=" + translations + "]";
	}

}
