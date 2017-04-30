package com.oot.usedcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.oot.usedcar.domain.Car;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CarRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private CarRepository carRepository;
	@Test
	public void testAddCar() {
		Car c = new Car();
		c.setBrand("Toyota");
		c.setYear(2016);
		 this.entityManager.persist(c);
	        Car car = this.carRepository.findByBrand("Toyota");
	        assertThat(car.getBrand()).isEqualTo("Toyota");
	}

}
