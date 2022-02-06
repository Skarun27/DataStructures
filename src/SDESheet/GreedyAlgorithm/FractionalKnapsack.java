package SDESheet.GreedyAlgorithm;

import java.util.Arrays;

public class FractionalKnapsack {
    static double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        double maxWeight = 0;
        int i = 0;
        Arrays.sort(arr, (Item a, Item b) -> b.value*a.weight - a.value*b.weight);
        while(W > 0 && i< n) {
            if(arr[i].weight <= W) {
                maxWeight += arr[i].value;
                W -= arr[i].weight;
            }
            else {
                maxWeight += ((double)arr[i].value / (double)arr[i].weight) * (double)W;
                W = 0;
            }
            i++;
        }
        return maxWeight;
    }

    static class Item {
        int value, weight;
        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    public static void main(String[] args) {
        int W = 50;
        Item i1 = new Item(60, 10);
        Item i2 = new Item(100, 20);
        Item i3 = new Item(120, 30);
        Item[] arr = new Item[]{i1, i2, i3};
        System.out.println(fractionalKnapsack(W, arr, arr.length));
    }
}
