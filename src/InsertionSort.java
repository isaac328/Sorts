import java.util.Random;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.time.StopWatch;
import processing.core.*;

public class InsertionSort extends PApplet 
{
	int N;
	int[] arr;
	int[] arrCopy;
	int i;
	int j;
	int w;
	int h;
	StopWatch timer;
	
	public static void main(String[] args)
	{
		PApplet.main("InsertionSort");
	}
	
	public void settings()
	{
		size(1000,800);
	}
	
	public void setup()
	{
		//initialize variables
		i = 0;
		N = Integer.parseInt(JOptionPane.showInputDialog(null, "Amount of Items:"));
		w = width/N;
		h = (height-50)/N;
		timer = new StopWatch();
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
	    
	    thread("insertionSort");
	    timer.start();
	}
	
	public void insertionSort()
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				this.j = j - 1;
				if(arr[j-1] > arr[j])
					swap(arr, j, j-1);
				else
					break;
				
				delay(50);
			}
		}
		timer.stop();
	}
	public void draw()
	{
		background(0);
		text(timer.toString(), width/2, 100);
		textSize(50);
		//show the blocks
		for(int i = 0; i < arr.length; i++)
		{
			//if its the counter make it red
			if(i == j)
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
			//else make it red
			else
			{
				fill(255);
				rect(i * w, height, w, -(arr[i] * h + h));
			}
		}
	}

	private void swap(int[] a, int i, int change) 
	{
		int helper = a[i];
		a[i] = a[change];
		a[change] = helper;
	}
}
