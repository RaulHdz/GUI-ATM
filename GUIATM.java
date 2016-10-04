import javax.swing.JOptionPane;
import java.util.*;

class GUIATM {
  public static int a;
  public static int b;
  public static int c;
  public static int z;
  public static String S = "";
  public static Scanner keyboard = new Scanner(System.in);
  public static void pedir() {
    S = JOptionPane.showInputDialog("Enter the positive amount of money divisible by 10 you want to withdraw:");
    a = Integer.parseInt(S);
    while (a % 10 != 0 || a < 0) {
      S = JOptionPane.showInputDialog("Enter a positive amount divisible by 10:");
      a = Integer.parseInt(S);
    }
    checar();
  }
  public static void checar() {
    if (a % 20 != 0) {
      b = 1;
      a = a - 50;
    }
    else {
      b = 0;
    }
    if (a < 0) {
      JOptionPane.showMessageDialog(null, "Can't retrieve that amount of money. Try another amount:", "ERROR!", JOptionPane.PLAIN_MESSAGE);
      pedir();
    }
    else {
      S = "";
      a = billetes(a, 500);
      a = billetes(a, 200);
      a = billetes(a, 100);
      if (b == 1) {
        S = S + "1 50 pesos bill\n";
        z = z + 1;
      }
      a = billetes(a, 20);
    }
  }
  public static int billetes(int x, int y) {
    c = x % y;
    x = (x - c) / y;
    if (x > 0) {
      S = S + x + " " + y + " pesos bill(s)\n";
      z = z + x;
    }
    return c;
  }
  public static void main(String[] args) {
    pedir();
    S = S + z + " total bill(s)";
    JOptionPane.showMessageDialog(null, S, "BILLS", JOptionPane.PLAIN_MESSAGE);
  }
}