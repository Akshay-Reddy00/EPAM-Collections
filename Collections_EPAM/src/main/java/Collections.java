import java.util.Arrays;

class DataWithList<E> {

        private int size = 0;

        private static final int DEF_CAPACITY = 10;

        private Object numbers[];

        //Default constructor
        public DataWithList() {
            numbers = new Object[DEF_CAPACITY];
        }

        //Add method
        public void join(E e) {
            if (size == numbers.length) {
                ensureCapacity();
            }
            numbers[size++] = e;
        }

        //Get method
        @SuppressWarnings("unchecked")
        public E get(int k) {
            if (k >= size || k < 0) {
                throw new IndexOutOfBoundsException("Index: " + k + ", Size " + k);
            }
            return (E) numbers[k];
        }

        //Remove method
        @SuppressWarnings("unchecked")
        public E remove(int k) {
            if (k >= size || k < 0) {
                throw new IndexOutOfBoundsException("Index: " + k + ", Size " + k);
            }
            Object item = numbers[k];
            int numElts = numbers.length - ( k + 1 ) ;
            System.arraycopy( numbers, k + 1, numbers, k, numElts ) ;
            size--;
            return (E) item;
        }

        //Get Size of list
        public int size() {
            return size;
        }

        //Print method
        @Override
        public String toString()
        {
            StringBuilder strbui = new StringBuilder();
            strbui.append('[');
            for(int i = 0; i < size ;i++) {
                strbui.append(numbers[i].toString());
                if(i<size-1){
                    strbui.append(",");
                }
            }
            strbui.append(']');
            return strbui.toString();
        }

        private void ensureCapacity() {
            int newSize = numbers.length * 2;
            numbers = Arrays.copyOf(numbers, newSize);
        }



        // Main function
        public static void main(String[] args)
        {
            DataWithList<Integer> list = new DataWithList<Integer>();

            //join elements
            list.join(1);
            list.join(2);
            list.join(3);
            list.join(4);
            list.join(5);
            list.join(6);

            System.out.println(list);

//delete elements from index
            list.remove(2);
            list.remove(4);

            System.out.println(list);

//print element with index
            System.out.println( list.get(0) );
            System.out.println( list.get(1) );
            System.out.println( list.get(3) );

//print List Size
            System.out.println(list.size());
        }
    }

