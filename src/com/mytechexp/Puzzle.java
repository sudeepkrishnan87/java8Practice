package com.mytechexp;

import java.util.Arrays;
import java.util.stream.Stream;

public class Puzzle {
    public static void main(String[] args) {
        Puzzle p=new Puzzle();
        int arr[]={0, -7, 2, 11, 0, 15, 0, 13, 12, 0};
        Arrays.stream(arr).forEach(i->System.out.print(i+","));
        int current_zeroIndex=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(i==0 && arr[i]==0) {
                current_zeroIndex = i;
                continue;
            }
            else if(arr[i]==0 && arr[i-1]!=0)
                current_zeroIndex=i;

            if(arr[i]!=0 && current_zeroIndex!=-1)
            {
               swap(arr,current_zeroIndex,i);
               while(arr[current_zeroIndex]!=0)
               {
                   current_zeroIndex++;
                   if(current_zeroIndex>i)
                       break;
               }
            }
        }
        Arrays.stream(arr).forEach(System.out::println);


    }
    public static void swap(int arr[], int i,int toReplace)
    {
        int temp=arr[i];
        arr[i]=arr[toReplace];
        arr[toReplace]=temp;
    }
}
