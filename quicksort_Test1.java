import java.util.Arrays;

public class quicksort_Test1 {

    // select sort
    public void selectSort(int[] a) {
        int t = 0;
        for (int i = 0; i < a.length - 1; i++){
            int index=i;
            for (int j = i + 1; j < a.length; j++){
                if (a[index] > a[j]) {
                    index=j;
                }
            }
            if(index!=i){ // swap the elements
                t = a[i];
                a[i] = a[index];
                a[index] = t;
            }
        }
    }


    // quick
    public void quickSort(int [] array, int low, int high) {// 传入low=0，high=array.length-1;
        int pivot, p_pos, i, t;// pivot-> middle index ; p_pos-> center value
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (i = low + 1; i <= high; i++)
                if (array[i] > pivot) {
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = t;
            }
            t = array[low];
            array[low] = array[p_pos];
            array[p_pos] = t;
            // partition and sort
            quickSort(array, low, p_pos - 1);// sort left half 
            quickSort(array, p_pos + 1, high);// sort right half
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 20, 15, 0, 6, 7, 2, 1, -5, 55 };
        quicksort_Test1 t1 = new quicksort_Test1();
        // t1.selectSort(nums);
        t1.quickSort(nums, 0, nums.length - 1);
        System.out.println("array after sort : " + Arrays.toString(nums));
    }
}

