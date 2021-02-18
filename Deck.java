class Deck {
  public String name;
  public double length;
  public double width;
  public int cost;

  public Deck(String name, double length, double width, int cost) {
    this.name = name;
    this.length = length;
    this.width = width;
    this.cost = cost;
  }

  @Override
  public String toString() {
    return String.format(name + ", " + length + ", " + width + ", " + cost);
  }
}