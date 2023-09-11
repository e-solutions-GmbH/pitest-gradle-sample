package de.esolutions.pitest.showcase.coffeeshop.service;

import de.esolutions.pitest.showcase.coffeeshop.hmi.DrinkType;
import de.esolutions.pitest.showcase.coffeeshop.repo.DrinksRepository;

import static de.esolutions.pitest.showcase.coffeeshop.repo.DrinkTO.DEFAULT_ID;

class CoffeeService {
  private final DrinksRepository drinksRepo;

  CoffeeService(DrinksRepository drinksRepo) {
    this.drinksRepo = drinksRepo;
  }

  int getId(DrinkType drinkType) {
    if ("coffee".equals(drinkType.toString())) {
      return DEFAULT_ID;
    }

    return drinksRepo.getDrinks()
        .stream()
        .filter(drinkTO -> drinkTO.name().equals(drinkType.toString()))
        .findFirst()
        .orElseThrow()
        .id();
  }
}