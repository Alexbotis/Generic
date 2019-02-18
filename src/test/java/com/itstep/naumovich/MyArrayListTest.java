package com.itstep.naumovich;
import org.junit.Assert;
import org.junit.Test;

public class MyArrayListTest {

    MyArrayList<Integer> myArrayList1 = new MyArrayList<Integer>(Integer.class, 0);
    MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(Integer.class, 10);
    MyArrayList<Integer> myArrayList2 = new MyArrayList<Integer>(Integer.class, 10);
    @Test
    public void ensureCapacityTest() throws Exception {

        for (int i = 0; i < 10; i++) {

            // Integer integer = new Integer(i);

            myArrayList.data[i] = i;

        }


        myArrayList.ensureCapacity(15);

        // int newCapasity = myArrayList.getCapasity();

        Assert.assertTrue(myArrayList.getCapasity() == 16);
        Assert.assertTrue(myArrayList.data[0] == 0);
        Assert.assertTrue(myArrayList.data[9] == 9);
        Assert.assertTrue(myArrayList.data[14] == null);
    }

    @Test
    public void pushBackTest() {

        for (int i = 0; i < 10; i++) {

            // Integer integer = new Integer(i);

            myArrayList.add(i, i);

        }


        myArrayList.getSize();

        myArrayList.pushBack(10);
        Assert.assertTrue(myArrayList.data[10] == 10);
    }

    @Test
    public void popFrontTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        myArrayList.popFront();
        //  myArrayList.getData();

        Assert.assertTrue(myArrayList.data[0] == 1);
        Assert.assertTrue(myArrayList.data[8] == 9);

    }

    @Test
    public void insertTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }

        myArrayList.insert(5, 10);

        Assert.assertTrue(myArrayList.data[0] == 0);
        Assert.assertTrue(myArrayList.data[5] == 10);
        Assert.assertTrue(myArrayList.data[10] == 9);

        myArrayList.insert(9, 20);
        Assert.assertTrue(myArrayList.data[9] == 20);
    }

    @Test
    public void popBackTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }

        myArrayList.popBack();

        Assert.assertTrue(myArrayList.data[9] == null);

    }

    @Test
    public void removeAtTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        myArrayList.removeAt(5);
        Assert.assertTrue(myArrayList.data[5] == 6);
        Assert.assertTrue(myArrayList.data[9] == null);
    }


    @Test
    public void removeTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }

        myArrayList.remove(5);
        Assert.assertTrue(myArrayList.data[5] == 6);

    }

    @Test
    public void removeAll() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        myArrayList.insert(5, 4);
        myArrayList.removeAll(4);

        Assert.assertTrue(myArrayList.data[4] == 5);
        Assert.assertTrue(myArrayList.data[5] == 6);
    }

    @Test
    public void clearTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        myArrayList.clear();

        Assert.assertTrue(myArrayList.data[0] == null);
        Assert.assertTrue(myArrayList.data[5] == null);
        Assert.assertTrue(myArrayList.data[9] == null);

    }

    @Test
    public void isEmptyTest() {

        Assert.assertTrue(myArrayList1.isEmpty() == true);

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }

        Assert.assertTrue(myArrayList.isEmpty() == false);
    }


    @Test
    public void indexOfTest() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }

        Assert.assertTrue(myArrayList.indexOf(2) == 2);
        Assert.assertTrue(myArrayList.indexOf(20) == -1);

    }

    @Test
    public void reversTest(){

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        myArrayList.revers();

        Assert.assertTrue(myArrayList.data[0] == 9);
        Assert.assertTrue(myArrayList.data[5] == 5);
        Assert.assertTrue(myArrayList.data[9] == 0);

    }
    @Test
    public void ShuffleTest(){


        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        myArrayList.Shuffle();
    }
    @Test
    public void equalsTest(){

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }

        Assert.assertTrue(myArrayList.equals(myArrayList1) == false);

        for (int i = 0; i < 10; i++) {
            myArrayList2.add(i, i);
        }
        Assert.assertTrue(myArrayList.equals(myArrayList2) == true);
    }

    @Test
    public void getElement() {

        for (int i = 0; i < 10; i++) {
            myArrayList.add(i, i);
        }
        Assert.assertTrue(myArrayList.getElement(5) == 5);

    }


    @Test
    public void cloneTest () {

        for(int i = 0; i < 10; i++) {
            myArrayList.data [i]= i;
        }

        MyArrayList<Integer> cloneArr = myArrayList.clone();

        Boolean isClone = isEqual(cloneArr, myArrayList);

        Assert.assertTrue(isClone);
    }

    private boolean isEqual(MyArrayList firstArr, MyArrayList secondArr){

        Boolean result = true;

        if(firstArr.getSize() != secondArr.getSize() ||
                firstArr.getCapasity() != secondArr.getCapasity()){

            result = false;
            return result;
        }

        if(firstArr.getData().length != secondArr.getData().length){

            result = false;
            return result;

        }

        Integer arrLength = firstArr.getData().length;

        for(int i = 0; i < arrLength; i++) {

            if(firstArr.getData()[i] != secondArr.getData()[i]){

                result = false;
                return result;

            }

        }

        return result;
    }



}


