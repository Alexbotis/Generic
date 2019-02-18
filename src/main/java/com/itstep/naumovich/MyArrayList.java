package com.itstep.naumovich;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MyArrayList<T> {

    //ArrayList<T> data;
    T[] data;
    private int size;
    private int capasity;


    public MyArrayList(Class<T> clazz,int capasity) {
        this.capasity = capasity;
        this.data = (T[])Array.newInstance(clazz,capasity );
        this.size=data.length;
    }


    public int getSize() {
        return size;
    }

    public int getCapasity() {
        return capasity;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public T[] getData() {
        return data;
    }
    public Class<?> getDataClass(){
        return data.getClass();
    }

    public String toString() {

        String res="";

        for (int i = 0; i < size; i++) {

            res=res+(data[i].toString() + " ");
        }

return res;
    }

    public void ensureCapacity(int new_size) {

        // создаем параметризованный массив
        Class<?> cl = this.data[0].getClass();
        // Class<?> cl = getDataClass();

        T[] bufferArray;
        bufferArray = (T[])Array.newInstance(cl, new_size);//

        if (this.capasity < new_size) {



            // копируем туда data
            int size = data.length;

            for (int i = 0; i < size; i++) {

                bufferArray[i] = data[i];

            }
            // определяем новую емкость массива
            this.capasity = (int) (1.5 * this.capasity + 1);

            // создаем массив ArrayList<T> data с новой емкостью
            this.data = (T[])Array.newInstance(cl, this.capasity);


            for (int i = 0; i < size; i++) {

                this.data[i] = bufferArray[i];

            }

        }


    }

    public void pushBack(T obj) {// добавление элемента в конец массива

        // добавим элемент
        int new_size = data.length + 1;
// создадим новый массив с сохранением элементов
        ensureCapacity(new_size);
// на последнюю позицию добавим  T obj
        data[new_size - 1] = obj;
    }

    public void popFront() {// удаление первого элемента из массива


        for (int i = 0; i < data.length - 1; i++) {

            data[i] = data[i + 1];// сдвиг влево
        }
        data[data.length - 1]= null;

    }

    public void add ( int index,T obj){


        data[index]= obj;
    }

    public void insert(int index, T obj) { // вставка нового элемента по указанному индексу со сдвигом в право

        int oldsize= getSize();
        int new_size =oldsize  + 1;
        ensureCapacity(new_size);

        if (index <= oldsize - 1) {



            for (int i = oldsize ; i > index ; i--) {


                data[i ] = data[i-1];

            }
            data[index] = obj;

        }

        else {
            System.out.print("индекс выходит за пределы ");
        }

    }


    public void removeAt(int index) { //удаление одного элемента по указанному индесу со сдвигом влево


        if (index >= 0 && index < data.length) {

            for (int i = index; i < data.length-1; i++) {

                data[i] = data[i + 1];
            }
            popBack();

        } else if (index == data.length - 1) {

            popBack();
        }else {
            System.out.print("индекс выходит за пределы ");
        }

    }


    public void remove(T obj) {// удаление элемента массива значение которого совпадает с заданным
// с дальнейшим сдвигом в лево

        for (int i = 0; i < data.length; i++) {

            if (data[i] == obj) {

                removeAt(i);

            }

        }


    }

    public void removeAll(T obj) {//удаление всех элементов массива значение которого совпадает с заданным


        for (int i = 0; i < data.length; i++) {

            if (data[i] == obj) {

                removeAt(i);
                i = i - 1;
            }
        }
    }


    public void popBack() { // удаление последнего элемента массива

        data[data.length - 1] = null;

    }

    public void clear() { // очистить массив

        for (int i = 0; i < data.length; i++) {

            data[i] = null;

        }

    }

    public boolean isEmpty() {

        if (getSize() == 0) {
            return true;
        } else
            return false;
    }


    public void trimToSize (){

      this.capasity= data.length;


    }

    public int indexOf(T obj) {

        int index = -1;

        for (int i = 0; i < data.length; i++) {

            if (data[i] == obj) {
                index = i;
                continue;
            }

        }
        return index;
    }

    public int lastIndexOf(T obj) {

        int index = -1;

        for (int i = data.length - 1; i < 1; i--) {

            if (data[i] == obj) {
                index = i;
                continue;
            }

        }
        return index;
    }

    public void revers() {

        int k = (int) (data.length / 2);
        T obj = null;

        for (int i = 0; i <= k; i++) {

            obj = data[i];
            data[i] = data[data.length - 1-i];
            data[data.length - 1-i] = obj;

        }

    }

    public void Shuffle() {

        final Random random = new Random();
        int length = data.length;
        int[] index = new int[length];
        T obj = null;
        Class<?> cl = this.data[0].getClass();
        // Class<?> cl = getDataClass();

        T[] bufferArray;
        bufferArray = (T[])Array.newInstance(cl, length);

        //index[0] = random.nextInt(length);
        //bufferArray [0]=data[index[0]];

        for (int i = 0; i < length; i++) {

            index[i] = random.nextInt(length);
           // if (i==0){
               // bufferArray [0]=data[index[0]];



            for (int j=0;j<i;j++){

                if (index[j]==index[i]){
                 i=i-1;
                 continue;
             }


                }
            bufferArray [i]=data[index[i]];
            }


        for (int i = 0; i < length; i++) {


            data[i] =  bufferArray [i];



        }

    }


    public boolean equals(MyArrayList newArrayList) {

        boolean result = true;

        if (data.length != newArrayList.getSize()) {
            result = false;
          return result;
        }

        for (int i = 0; i < data.length; i++) {
            if (this.data[i] != newArrayList.data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public T getElement(int index) {

        T obj = null;
        if (index < data.length) {

            obj = data[index];

        }else{

            System.out.print("индекс выходит за пределы ");

        }
        return obj;

    }

    public MyArrayList clone() {

        Class<?> cl = this.data[0].getClass();

        int new_capasity = this.capasity;

        MyArrayList clone = new MyArrayList(cl,new_capasity);

        for (int i = 0; i < data.length; i++) {

            clone.data[i] = this.data[i];

        }

        return clone;
    }


}





