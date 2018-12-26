import java.util.Random;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import org.apache.commons.lang3.time.StopWatch;

public class QuickSort extends PApplet 
{
	int N;
	int[] arr;
	int pivot;
	int left;
	int right;
	int w;
	int h;
	StopWatch timer;
	
	public static void main(String[] args)
	{
		PApplet.main("QuickSort");
	}
	
	public void settings()
	{
		size(1000,800);
	}
	
	public void setup()
	{
		//initialize variables
		left = 0;
		right = N;
		timer = new StopWatch();
		N = Integer.parseInt(JOptionPane.showInputDialog(null, "Amount of Items:"));
		w = width/N;
		h = (height-50)/N;
		
		//make the array and ititialize it with values
		arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = i;
	
		//make an instance of random
		Random random = new Random();
	    random.nextInt();
	    
	    //shuffle the array
	    for (int i = 0; i < N; i++) 
	    {
	    	int change = random.nextInt(N);
	        swap(arr, i, change);
	    }
	    
	    thread("quickSort");
	    timer.start();
	}
	
	public void draw()
	{
		background(0);
		text(timer.toString(), width/2, 100);
		textSize(50);
		
		for(int i = 0; i < arr.length; i++)
		{
			//if its the counter make it red
			if(i == left || i == right)
			{
				fill(255,0,0);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
			//if its in the right spot make it green
			else if(arr[i] == i)
			{
				fill(0,255,0);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
			//if its the pivot make it blue
			else if(arr[i] == pivot)
			{
				fill(0,0,255);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
			//else make it white
			else
			{
				fill(255);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
		}
	}
	
	public void quickSort()
	{
			quickSort(arr, 0, arr.length-1);
	}
	
	private void quickSort(int[] a, int lo, int hi) 
	{ 
        if (hi <= lo)
        {
        	 System.out.println(timer.getTime());
        	 return;
        }
        pivot = partition(a, lo, hi);
        quickSort(a, lo, pivot-1);
        quickSort(a, pivot+1, hi);
        //assert isSorted(a, lo, hi);
        
        //timer.stop();
       
    }
	
	 private int partition(int[] a, int lo, int hi) 
	    {
	        //int i = lo;
	        //int j = hi + 1;
		 	left = lo;
		 	right = hi + 1;
	        int v = a[lo];
	        this.pivot = v;
	        while (true) { 

	            // find item on lo to swap
	            while (a[++left] < v)
	            {
	            	if (left == hi) 
	                	break;
	            	delay(50);
	            }

	            // find item on hi to swap
	            while (v < a[--right])
	            {
	            	if (right == lo) 
	                	break;
	            	delay(50);
	            }

	            // check if pointers cross
	            if (left >= right) 
	            	break;

	            swap(a, left, right);
	            delay(50);
	        }

	        // put partitioning item v at a[j]
	        swap(a, lo, right);
	        delay(50);
	        

	        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	        return right;
	    }
	
	private void swap(int[] a, int i, int change) 
	{
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}
}
