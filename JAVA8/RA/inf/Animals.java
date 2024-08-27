package JAVA8.RA.inf;
@FunctionalInterface
public interface Animals {
    int a=10;
    String move(String s);
  default void eat(){};
}
