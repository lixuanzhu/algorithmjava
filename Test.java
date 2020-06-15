import java.util.ArrayList;

class Test {
    public static void main(String[] args){
        int[] a = {1,2,3};
        for(int b : a){
            System.out.println(b);
        }

        a = new int[] {5,6};
        for(int b : a){
            System.out.println(b);
        }
    }
}