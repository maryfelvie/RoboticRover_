package br.robotic.rover.lib.Enum;

public enum Action {
   L, R, M;
   
   public static Action fromString(String text) {
    if (text != null) {
      for (Action b : Action.values()) {
        if (text.equalsIgnoreCase(b.name())) {
          return b;
        }
      }
    }
    return null;
  }
}
