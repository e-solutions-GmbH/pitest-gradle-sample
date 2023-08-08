package de.esolutions.pitest.showcase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PresenterTest {

  @Test
  void shouldSetDataCorrectlyWhenNoFilterIsSet() {
    // GIVEN
    Model model = mock(Model.class);
    View view = mock(View.class);
    Data data1 = mock(Data.class);

    doAnswer(i -> {
      i.<Consumer<List<Data>>> getArgument(0)
          .accept(List.of(data1));
      return null;
    }).when(model)
        .onDataUpdated(any());

    // WHEN
    new Presenter(view, model);

    // THEN
    assert (data1.value() == 0);
  }

  @Test
  void shouldSetDataCorrectlyWhenFilterIsSet() {
    // GIVEN
    Model model = mock(Model.class);
    View view = mock(View.class);

    doAnswer(i -> {
      i.<Consumer<String>> getArgument(0)
          .accept("filter0");
      return null;
    }).when(view)
        .onFilterSelected(any());

    // WHEN
    new Presenter(view, model);

    // THEN
    verify(view).onFilterSelected(any());
  }
}