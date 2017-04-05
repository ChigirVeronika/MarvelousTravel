package by.bsuir.travel.service;

import by.bsuir.travel.entity.Country;
import by.bsuir.travel.entity.Region;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RegionService {
    Map<Region,List<Country>> getRegionsWithCountries();
}
/*
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
   <c:forEach items="${map}" var="mapElement">
      <tr>
           <td>${mapElement.key}</td>
           <c:forEach items="${mapElement.value}" var="listElement" >
              <td>${listElement}</td>
           </c:forEach>
      </tr>
   </c:forEach>
<table>
*/