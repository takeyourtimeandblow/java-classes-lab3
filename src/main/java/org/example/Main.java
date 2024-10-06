package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        for (int i=1; i<=10; i++)
            button.click();

        Balance libra = new Balance();
        libra.addLeft(5);
        libra.addRight(1);
        System.out.println(libra.result());

        libra.addLeft(5);
        libra.addRight(5);
        System.out.println(libra.result());

        Bell cowbell = new Bell();
        for (int i=1; i<=10; i++)
            System.out.println(cowbell.sound());

        OddEvenSeparator sep = new OddEvenSeparator();
        for (int i=1; i<=20; i++){
            sep.addNumber(i);
        }
        System.out.println(sep.getEven());
        System.out.println(sep.getOdd());

        Table table = new Table(7, 4);
        if (table.getIsValid()) {
            System.out.println(Arrays.deepToString(table.getList2D()));
            System.out.println(table.getValue(3, 2));
            table.setValue(3, 2, 42);
            System.out.println(Arrays.deepToString(table.getList2D()));

            System.out.println(table.rows());
            System.out.println(table.cols());
            System.out.println(table.toString());
            System.out.println(table.average());
        }
    }
}
class Button {
    private int count;

    public Button(){
        count = 0;
    }

    public void click(){
        ++count;
        System.out.println("Button was clicked " + count + " times");
    }


}
class Balance{
    private static int l, r;

    Balance(){
        l = 0;
        r = 0;
    }

    public void addRight(int r){
        Balance.r = r;
    }
    public void addLeft(int l){ Balance.l = l; }
    public char result(){
        if(l>r)
            return 'L';
        else if(r>l)
            return 'R';
        else
            return '=';
    }

}
class Bell{
    private boolean evenUsage;

    public Bell(){
        evenUsage = false;
    }

    public String sound(){
        if (evenUsage) {
            evenUsage = false;
            return "dong";
        }
        evenUsage = true;
        return "ding";
    }


}
class OddEvenSeparator{
    private final ArrayList<Integer> even;
    private final ArrayList<Integer> odd;

    public OddEvenSeparator(){
        even = new ArrayList<>();
        odd = new ArrayList<>();
    }
    public void addNumber(int num){
        if (num%2 == 0) {
            even.add(num);
        } else {
            odd.add(num);
        }
    }
    public ArrayList<Integer> getEven(){
        return even;
    }
    public ArrayList<Integer> getOdd(){
        return odd;
    }
}
class Table{
    private Integer[][] list2D;
    private static boolean isValid;
    Table(int row, int col){
        if (checkValid(row, col)) {
            list2D = new Integer[row][col];
            for (int i=0; i<col; i++)
                for (int j=0; j<row; j++)
                    list2D[j][i] = j+i;
        }
    }

    public boolean checkValid(int row, int col) {
        isValid = row > 0 && col > 0;
        return isValid;
    }
    public boolean getIsValid(){
        return isValid;
    }
    public Integer[][] getList2D(){
        return list2D;
    }
    public void setValue(int row, int col, int num){
        if ((row < list2D.length) && (col < list2D[0].length))
            list2D[row][col]= num;
        else System.out.println("setValue error");
    }
    public int getValue(int row, int col){
        if ((row < list2D.length) && (col < list2D[0].length))
            return list2D[row][col];
        System.out.println("getValue error; ");
        return 0;
    }
    public int rows(){
        return list2D.length;
    }
    public int cols(){
        return list2D[0].length;
    }
    @Override //of Object.toString()
    public String toString() {
        StringBuilder matrix = new StringBuilder();

        for (Integer[] integers : list2D) {
            for (int j = 0; j < list2D[0].length; j++) {
                if (j != list2D[0].length - 1) {
                    matrix.append(integers[j]);
                    matrix.append('\t');
                } else matrix.append(integers[j]);
            }
            matrix.append('\n');
        }
        return String.valueOf(matrix);
    }
    public int average(){
        int sum = 0;
        int total = list2D.length * list2D[0].length;
        for (Integer[] integers : list2D) {
            for (int j = 0; j < list2D[0].length; j++) {
                sum += integers[j];
            }
        }
        if (total!=0)
            return sum/total;
        return 0;
    }

}