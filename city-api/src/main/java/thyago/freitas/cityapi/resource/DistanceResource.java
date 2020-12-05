package thyago.freitas.cityapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import thyago.freitas.cityapi.service.DistanceService;

@RestController
@RequestMapping("/api/v1/distances")
public class DistanceResource {

  private final DistanceService distanceService;

  @Autowired
  DistanceResource(DistanceService distanceService) {
    this.distanceService = distanceService;
  }

  @GetMapping("/by-cube")
  public ResponseEntity<Double> calcDistanceCube(
      @RequestParam("from") Long city1,
      @RequestParam("to") Long city2
  ) {
    Double distanceCube = distanceService.calcDistanceCube(city1,city2);
    return ResponseEntity.ok(distanceCube);
  }

  @GetMapping("/by-point")
  public ResponseEntity<Double> calcDistancePoint(
      @RequestParam("from") Long city1,
      @RequestParam("to") Long city2
  ) {
    Double distancePoint = distanceService.calcDistancePoint(city1,city2);
    return ResponseEntity.ok(distancePoint);
  }

}