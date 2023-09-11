package de.esolutions.pitest.showcase.coffeeshop.service;

import de.esolutions.pitest.showcase.coffeeshop.hmi.DrinkType;
import de.esolutions.pitest.showcase.coffeeshop.repo.DrinkTO;
import de.esolutions.pitest.showcase.coffeeshop.repo.DrinksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static de.esolutions.pitest.showcase.coffeeshop.repo.DrinkTO.DEFAULT_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class CoffeeServiceTest {
  @Mock
  DrinksRepository repo;
  @InjectMocks
  CoffeeService    service;

  @BeforeEach
  void beforeEach() {
    List<DrinkTO> drinks = List.of(
        new DrinkTO("coffee", 0),
        new DrinkTO("cappuccino", 1),
        new DrinkTO("latte macchiato", 2)
    );
    lenient().when(repo.getDrinks()).thenReturn(drinks);
  }

  @Test
  void returnsDefaultIdForCoffee() {
    // when
    int result = service.getId(DrinkType.COFFEE);

    // then
    assertThat(result).isEqualTo(DEFAULT_ID);
  }

  @ParameterizedTest
  @CsvSource({ "CAPPUCCINO,1", "LATTE_MACCHIATO,2" })
    // indeed all values excluding COFFEE
  void returnsQueriedIdForCoffeeType(DrinkType drinkType, int expectedId) {
    // when
    int result = service.getId(drinkType);

    // then
    assertThat(result).isEqualTo(expectedId);
  }
}