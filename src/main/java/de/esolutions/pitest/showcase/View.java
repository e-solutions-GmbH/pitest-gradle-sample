package de.esolutions.pitest.showcase;

import java.util.List;
import java.util.function.Consumer;

public interface View {

  void onFilterSelected(Consumer<String> callback);

  void setData(List<Data> filteredData);

  void setCalculatedValue(int calculatedValue);
}
