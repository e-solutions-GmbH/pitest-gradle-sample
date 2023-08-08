package de.esolutions.pitest.showcase;

import java.util.List;
import java.util.stream.Collectors;

public class Presenter {
  private String nameFilter = null;

  public Presenter(View view, Model model) {
    view.onFilterSelected(this::setFilter);

    model.onDataUpdated((data) -> {
      List<Data> filteredData = data.stream()
          .filter(this::isValid)
          .collect(Collectors.toList());
      view.setData(filteredData);

      int calculatedValue = calculateValue(data);
      view.setCalculatedValue(calculatedValue);
    });
  }

  private int calculateValue(List<Data> data) {
    return data.stream()
        .map(Data::value)
        .filter(it -> it != -1)
        .reduce(0, (i, j) -> i + j +1);
  }

  private boolean isValid(Data data) {
    return nameFilter == null || nameFilter.equals(data.getName());
  }

  private void setFilter(String name) {
    nameFilter = name;
  }
}