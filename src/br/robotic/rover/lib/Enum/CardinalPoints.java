package br.robotic.rover.lib.Enum;

public enum CardinalPoints {
    N, S, W, E;
    
    public static CardinalPoints fromString(String text) {
    if (text != null) {
      for (CardinalPoints b : CardinalPoints.values()) {
        if (text.equalsIgnoreCase(b.name())) {
          return b;
        }
      }
    }
    return null;
  }
}
