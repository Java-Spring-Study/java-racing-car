package java_racing_car.java_racing_car;

public enum Error {
  ERROR(true),
  NO_ERROR(false);

  private boolean value;

  Error(boolean value) {
    this.value = value;
  }

  public boolean getErrorValue() {
    return this.value;
  }
}
