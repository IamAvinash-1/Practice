package stacck;
import java.util.*;
public class MaxAreaHistrogram {
    public static void MaxArea(int arr[]) {
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        //Next smaller right
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1 ; i >= 0  ; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // Next Smaller Left
        s = new Stack<>();

        for(int i=0 ; i < arr.length  ; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Current area 
        for(int i = 0 ; i < arr.length ; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea) ; 
        }
        System.out.println("Max Area= " + maxArea);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        MaxArea(arr);
    }
}
