public class MaxQueue{
    private int[] queue;
    private int size;
    private int capacity;

    public MaxQueue (int capacity){
        this.queue = new int[capacity];
        this.size = 0;
        this.capacity  = capacity;
    }

    public int GetSize()
    {
        return size;
    }
    
    public void add(int x){
        if(size < capacity){
            queue[size] = x;
            size ++;
            moveUp();
        } else if (queue[0] > x){
            queue[0] = x; 
            moveDown();
        }
    }

    public int remove(){
        if(size == 0){
            return -1;
        }

        Util.swap(queue, 0, size -1);
        size--;
        moveDown();

        return queue[size];
    }

    public int peek(){
        return queue[0];
    }

    private void moveUp()
    {
        int c = size - 1;
        while ( c != 0){
            int p = (c + 1) / 2 -1;
            if( queue[c] < queue[p]){
                return;
            }
            Util.swap(queue, c, p);
            c = p;
        }
    }

    private void moveDown(){
        int p = 0;
        while (p < size - 1){
            int l = (p + 1) * 2 -1;
            if(l > size - 1){
                return;
            }

            if(l == size - 1 ){
                if(queue[p] < queue[l]){
                    Util.swap(queue, p, l);
                }
                return;
            }

            int m = queue[l+1] < queue[l] ? l : l + 1;
            if(queue[p] >  queue[m]){
                return;
            }

            Util.swap(queue, p, m);
            p = m;
        }
    }
}