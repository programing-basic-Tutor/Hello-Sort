import java.util.Stack;
public class quickSort{
    public static void sortByStack(int[] a) {
        Stack<Integer> stack = new Stack<Integer>();

    //initialize left and right pointer to stack
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
        // pop out element and partition
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(a, low, high);

        //save middle variable
            if (pivotIndex > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex < high && pivotIndex >= 0) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] a, int low, int high) {
        if (low >= high) return -1;
        int left = low;
        int right = high;
    //
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = pivot;
        return left;
    }

    public static void main(String[] args) 
        {
            int[] numbers = {10,20,15,0,6,7,2,1,-5,55};
            System.out.print("array before sort :");
            for(int i = 0 ; i < numbers.length ; i ++ ){
                System.out.print(numbers[i] + ",");
            }
            System.out.println("");

            sortByStack(numbers);
            System.out.print("array after sort :");
            for(int i = 0 ; i < numbers.length ; i ++ ){
                System.out.print(numbers[i] + ",");
            }
        }
}
