package com.afkl.travel.exercise.repository.implementation;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afkl.travel.exercise.model.Location;
import com.afkl.travel.exercise.repository.LocationRepoByTypeAndCode;

@Component
public class LocationRepoByTypeAndCodeImpl implements LocationRepoByTypeAndCode {

	@Autowired
	private EntityManager em;

	@Override
	public Location getLocationByTypeAndCode(String type, String code) {
		return (Location)em.createQuery("SELECT l FROM Location l WHERE l.type=:type AND l.code=:code")
			.setParameter("type", type)
			.setParameter("code", code)
			.getSingleResult();
	}

}
