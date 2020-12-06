package com.njesoft.springboottesting.unit.repository;

import com.njesoft.springboottesting.model.Arrival;
import com.njesoft.springboottesting.repository.ArrivalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class ArrivalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArrivalRepository arrivalRepository;

    @Test
    public void whenFindAll() {
        //given
        Arrival firstArrival = new Arrival();
        firstArrival.setCity("Brussels");
        entityManager.persist(firstArrival);
        entityManager.flush();

        Arrival secondArrival = new Arrival();
        secondArrival.setCity("Barcelona");
        entityManager.persist(secondArrival);
        entityManager.flush();

        //when
        List<Arrival> arrivals = arrivalRepository.findAll();

        //then
        assertThat(arrivals.size()).isEqualTo(9);
        assertThat(arrivals.get(7)).isEqualTo(firstArrival);
        assertThat(arrivals.get(8)).isEqualTo(secondArrival);
    }


    @Test
    public void whenFindAllById() {
        //given
        Arrival arrival = new Arrival();
        arrival.setCity("Barcelona");
        entityManager.persist(arrival);
        entityManager.flush();

        //when
        Arrival testArrival = arrivalRepository.findAllById(arrival.getId());

        //then
        assertThat(testArrival.getCity()).isEqualTo(arrival.getCity());
    }
}