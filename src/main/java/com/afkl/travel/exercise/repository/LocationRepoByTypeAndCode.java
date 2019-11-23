package com.afkl.travel.exercise.repository;

import com.afkl.travel.exercise.model.Location;

public interface LocationRepoByTypeAndCode {
	Location getLocationByTypeAndCode(String type, String code);
}
