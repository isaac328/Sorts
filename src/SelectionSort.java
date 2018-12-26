import java.util.Random;
import javax.swing.JOptionPane;
import processing.core.*;

public class SelectionSort extends PApplet 
{
	int N = 100;
	int[] arr;
	int min;
	int i;
	int j;
	int w;
	int h;
	
	public static void main(String[] args)
	{
		PApplet.main("SelectionSort");
	}
	
	public void settings()
	{
		size(1000,800);
	}
	
	public void setup()
	{
		//initialize variables
		i = 0;
		min = 0;
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
	    
	    thread("selectionSort");
	}
	
	public void selectionSort()
	{
		for(int i = 0; i < arr.length; i++)
		{
			min = i;
			this.i = i;
			for(int j = i + 1; j < arr.length; j++)
			{
				this.j = j;
				if(arr[j] < arr[min])
					min = j;
				delay(50);
			}
			swap(arr, i, min);
		}
	}
	
	public void draw()
	{
		background(0);
		
		//draw the rectangles
		for(int i = 0; i < arr.length; i++)
		{
			//if its the counter, make it red
			if(i == this.j)
			{
				fill(255,0,0);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
			//if its already been sorted, make it green
			else if(i < this.i)
			{
				fill(0, 255, 0);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
			//if its still to be sorted, make it white
			else
			{
				fill(255);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
		}
		
		delay(50);
	}
	
	private void swap(int[] a, int i, int change) 
	{
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}
}
