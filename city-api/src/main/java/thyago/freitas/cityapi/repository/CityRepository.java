package thyago.freitas.cityapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import thyago.freitas.cityapi.model.CityModel;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {

  @Query(
      value =
          "select earth_distance( " +
          "ll_to_earth(?1,?2), " +
          "ll_to_earth(?3,?4) " +
          ") as distance",
      nativeQuery = true)
  Double calcDistanceCube(Double lat1, Double long1, Double lat2, Double long2);

  @Query(
      value = "select ((select lat_lon from cidade where id = ?1) <@> (select lat_lon from cidade where id = ?2 )) as distance",
      nativeQuery = true)
  Double calcDistancePoint(Long city1, Long city2);
}