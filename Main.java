import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    Deck[] deckInfo = getDeckInfo();
    String choice = "";
    //System.out.println(Arrays.deepToString(deckInfo));
    while(!choice.equals("4")) {
      showOptions();
      choice = reader.nextLine();
      if (choice.equals("1")) {
        Deck cheapest = deckInfo[0];
        for (int i = 0; i < deckInfo.length; i++) {    
          int cheapestPrice = deckInfo[0].cost;
          int currPrice = deckInfo[i].cost;
          if (currPrice < cheapestPrice) {
            cheapest = deckInfo[i];
          } 
        }
        System.out.println(cheapest.name + " is the cheapest deck at £" + cheapest.cost);
      }

      else if (choice.equals("2")) {
        System.out.println("Enter a length between 2 and 15 metres: ");
        boolean[] list = {false, false, false, false, false, false};
        double length = Double.parseDouble(reader.nextLine());
        for (int i = 0; i < deckInfo.length; i++) {
          if (deckInfo[i].length >= length) {
            list[i] = true;
          }
        }
        System.out.println("The decks over " + length + "m long are: \n");
        for (int i = 0; i < list.length; i++) {
          if (list[i] == true) {
            System.out.println(deckInfo[i].name);
          }
        }
      }

      else if (choice.equals("3")) {
        System.out.println("Enter an area between 4 and 80 metres squared: ");
        double area = Double.parseDouble(reader.nextLine());
        int numberOfDecks = 0;
        for (int i = 0; i < deckInfo.length; i++) {
          if (deckInfo[i].width*deckInfo[i].length >= area) {
            numberOfDecks += 1;
          }
        }
        System.out.println("There are " + numberOfDecks + " decks over " + area + " metres squared.");
      }  
    }
    System.out.println("You have exited the program");
  }

  public static Deck[] getDeckInfo() {
    String[][] deckInfo = new String[6][4];
    try {
      FileReader fr = new FileReader("Decks.csv");
      BufferedReader br = new BufferedReader(fr);
      
      int i = 0;
      String line = br.readLine();

      while (line != null) {
        deckInfo[i] = line.split(",");
        //System.out.println(line);
        line = br.readLine();
        i++;
      }
      fr.close();
      br.close();
    }
    catch (Exception e) {
      System.out.println("Could not locate the data file!");
    }
    Deck deck1 = new Deck(deckInfo[0][0], Double.parseDouble(deckInfo[0][1]), Double.parseDouble(deckInfo[0][2]), Integer.parseInt(deckInfo[0][3]));
    Deck deck2 = new Deck(deckInfo[1][0], Double.parseDouble(deckInfo[1][1]), Double.parseDouble(deckInfo[1][2]), Integer.parseInt(deckInfo[1][3]));
    Deck deck3 = new Deck(deckInfo[2][0], Double.parseDouble(deckInfo[2][1]), Double.parseDouble(deckInfo[2][2]), Integer.parseInt(deckInfo[2][3]));
    Deck deck4 = new Deck(deckInfo[3][0], Double.parseDouble(deckInfo[3][1]), Double.parseDouble(deckInfo[3][2]), Integer.parseInt(deckInfo[3][3]));
    Deck deck5 = new Deck(deckInfo[4][0], Double.parseDouble(deckInfo[4][1]), Double.parseDouble(deckInfo[4][2]), Integer.parseInt(deckInfo[4][3]));
    Deck deck6 = new Deck(deckInfo[5][0], Double.parseDouble(deckInfo[5][1]), Double.parseDouble(deckInfo[5][2]), Integer.parseInt(deckInfo[5][3]));

    Deck[] decks = new Deck[] {deck1, deck2, deck3, deck4, deck5, deck6};
    //System.out.println(Arrays.deepToString(deckInfo));
    return decks;
  }
  public static void showOptions() {
    System.out.println("What would you like to search for:       (Enter 1, 2, 3, or 4)");
    System.out.println("1. The cheapest deck");
    System.out.println("2. The decks that are over a certain length");
    System.out.println("3. The number of decks that are over a certain area");
    System.out.println("4. Exit");
  }
}




