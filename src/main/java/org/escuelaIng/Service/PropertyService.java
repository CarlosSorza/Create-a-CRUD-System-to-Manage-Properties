package org.escuelaIng.Service;

import org.escuelaIng.repository.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    Property create(Property property);
    Optional<Property> getById(long id);
    List<Property> findAll();
    void removeById(long id);
    Property modify(Property property, long id);
    List<Property> findProperties(String location, Double minCost, Double maxCost, Double minArea, Double maxArea);
}
