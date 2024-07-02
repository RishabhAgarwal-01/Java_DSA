package com.stackandqueue;

public class DynamicStack extends StackImplementation {
    public DynamicStack(){
        super(); //it will call StackImplementation() constructor
    }
    public DynamicStack(int size){
        super(size); //will call the StackImplementation(int size) constructor
    }

    @Override
    public boolean push(int item) {
        //this is for when data array is full
        if(this.isFull()){
            //double the size
            int[] temp= new int[data.length*2];

            for(int i=0;i< data.length;i++){
              temp[i]= data[i];
            }
            data= temp;
        }
        //if it is not full then simply push the data in the data array of the super class
        return super.push(item);

    }
}
