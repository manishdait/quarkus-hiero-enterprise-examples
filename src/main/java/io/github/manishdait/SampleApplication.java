package io.github.manishdait;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class SampleApplication implements QuarkusApplication {
  @Inject
  private ExampleRunner exampleRunner;

  @Override
  public int run(String... args) throws Exception {
    exampleRunner.runAll();
    return 0;
  }
}
