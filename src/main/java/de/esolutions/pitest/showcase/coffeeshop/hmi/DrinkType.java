package de.esolutions.pitest.showcase.coffeeshop.hmi;

public enum DrinkType {
  COFFEE("coffee"),
  CAPPUCCINO("cappuccino"),
  LATTE_MACCHIATO("latte macchiato");

  private final String name;

  DrinkType(String name) {
    this.name = name;
  }

  String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return name;
  }

  public final static DrinkType DEFAULT = DrinkType.COFFEE;
}
