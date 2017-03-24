/**
 * 
 * @author Rajat
 * Purpose: This class is the implementation for the stack concept.
 * Date: Apr 8, 2016
 */
public class StackOfIntegers {

	int[] elementArray;
	int sizeOfStack;

	// Default constructor - constructs empty stack with size 16.
	public StackOfIntegers() {
		elementArray = new int[16];
	}
	//Constructs an empty stack with a specified capacity.
	public StackOfIntegers(int size) {
		elementArray = new int[size];
	}
	//Returns true if the stack is empty.
	public boolean empty() {
		return sizeOfStack == 0;
	}
	//Returns the integer at the top of the stack without removing it from the stack.
	public int peek() {
		return elementArray[sizeOfStack-1];
	}
	//Stores an integer into the top of the stack.
	public void push(int number) {
		if(sizeOfStack >= elementArray.length) {
			int[] temp = new int[elementArray.length * 2];
			System.arraycopy(elementArray, 0, temp, 0, elementArray.length);
			elementArray = temp;
		}
		elementArray[sizeOfStack++] = number;
	}
	//Removes the integer at the top of the stack and returns it.
	public int pop() {
		return elementArray[--sizeOfStack];
	}
	//Returns the number of elements in the stack.
	public int getSize() {
		return sizeOfStack;
	}
}
