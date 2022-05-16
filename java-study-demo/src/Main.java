import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> str = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      str.add("one: " + i);
    }

    System.out.println(str);
  }
}
