package com.travelAdvisor.core.dao.directions;

import com.travelAdvisor.core.model.DirectionsTravelInformation;

/**
 * Created by shahaf.sages on 9/24/16.
 */
public interface DirectionsTravelInformationDao {

    DirectionsTravelInformation travel(final DirectionsTravelInformation travelInformation);
}
