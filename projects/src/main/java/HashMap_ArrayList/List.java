public class List<Type> {

    private Type[] values;
    private int firstFreeIndex;

    public List(){
        values = (Type[]) new Object[10];
        firstFreeIndex = 0;
    }

    public void add(Type value){
        if (value == null){
            throw new NullPointerException("Object is null");
        }

        if (values.length == firstFreeIndex){
            grow();
        }

        values[firstFreeIndex] = value;
        firstFreeIndex++;
    }

    public void remove(Type value){
        int indexOfValue = indexOf(value);
        if (indexOfValue < 0){
            return;
        }

        moveToTheLeft(indexOfValue);
        firstFreeIndex--;
    }

    public void remove(int index){
        if (index < 0 || index >= firstFreeIndex){
            throw new ArrayIndexOutOfBoundsException();
        }

        moveToTheLeft(index);
        firstFreeIndex--;
    }

    public void moveToTheLeft(int index){
        for (int i = index; index < firstFreeIndex - 1; i++){
            values[i] = values[i + 1];
        }
    }

    public boolean contains(Type value){
        return indexOf(value) >=  0;
    }

    public int indexOf(Type value){
        for (int i = 0; i < firstFreeIndex; i++){
            if (values[i].equals(value)){
                return i;
            }
        }

        return -1;
    }

    public boolean isEmpty(){
        return firstFreeIndex == 0;
    }

    public Type get(Type value){
        return values[indexOf(value)];
    }

    private void grow(){
        int newSize = values.length + values.length / 2;
        Type[] newArray = (Type[]) new Object[newSize];

        for (int i = 0; i < firstFreeIndex; i++){
            newArray[i] = values[i];
        }

        values = newArray;
    }

    public int size(){
        return firstFreeIndex;
    }

    public Type value(int index){
        if (index < 0 || index >= firstFreeIndex){
            throw new ArrayIndexOutOfBoundsException();
        }

        return values[index];
    }
    
}
