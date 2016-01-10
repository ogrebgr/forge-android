/*
 * Copyright (C) 2012-2015 Ognyan Bankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bolyartech.forge.misc;

/**
 * Utility class that provides methods for working with location
 */
@SuppressWarnings("WeakerAccess")
public class LocationUtils {
    @SuppressWarnings("WeakerAccess")
    public static final double EARTH_RADIUS = 6371 * 1000;


    /**
     * Noninstantiable utility class
     */
    private LocationUtils() {
        throw new AssertionError();
    }


    /**
     * Calculates distance between two points using Haversine formula (https://en.wikipedia.org/wiki/Haversine_formula)
     *
     * @param lat1 Latitude 1
     * @param lon1 Longitude 1
     * @param lat2 Latitude 2
     * @param lon2 Longitude 2
     * @return Distance between two points in meters
     */
    @SuppressWarnings("unused")
    public static double distanceHaversine(double lat1, double lon1, double lat2, double lon2) {
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

}
