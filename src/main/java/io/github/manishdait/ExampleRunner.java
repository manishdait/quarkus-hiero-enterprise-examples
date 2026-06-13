package io.github.manishdait;

import com.openelements.hiero.base.HieroException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExampleRunner {
  @Inject
  private Instance<Example> examples;

  public void runAll() throws HieroException {
    for (Example example : examples) {
      example.run();
    }
  }
}
