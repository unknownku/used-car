package com.oot.usedcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oot.usedcar.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	Car findByBrand(String brand);
	Car findByModel(String model);
	Car findBySubModel(String subModel);
	Car findByYear(int year);
	Car findByBrandAndModelAndYear(String brand, String model, int year); 
	Car findByBrandAndModelAndSubModelAndYear(String brand, String model, String subModel, int year); 
	List<Car> findDistinctCarByBrand(String brand);
	List<Car> findDistinctCarByBrandAndModel(String brand, String model);
	List<Car> findDistinctCarByBrandAndModelAndSubModel(String brand, String model, String subModel);
	List<Car> findDistinctCarByBrandAndModelAndSubModelAndYear(String brand, String model, String subModel, int year);
	Car findById(Long id); 
	
	@Query("SELECT DISTINCT c.brand FROM Car c")
	public List<String> findBrand();
		
	@Query("SELECT DISTINCT c.model FROM Car c WHERE c.brand = :brand")
	public List<String> findModel(@Param("brand") String brand);
	
	@Query("SELECT DISTINCT c.subModel FROM Car c WHERE c.brand = :brand AND c.model = :model")
	public List<String> findSubModel(@Param("brand") String brand, @Param("model") String model);
	
	@Query("SELECT DISTINCT c.year FROM Car c WHERE c.brand = :brand AND c.model = :model AND c.subModel = :subModel")
	public List<String> findYear(@Param("brand") String brand, @Param("model") String model, @Param("subModel") String subModel);

}
