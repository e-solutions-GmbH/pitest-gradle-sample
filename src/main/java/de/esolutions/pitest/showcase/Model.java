package de.esolutions.pitest.showcase;

import java.util.List;
import java.util.function.Consumer;

public interface Model {
  void onDataUpdated(Consumer<List<Data>> data);
}
