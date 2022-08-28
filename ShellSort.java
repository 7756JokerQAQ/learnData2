@SuppressWarnings({"all"})
public class ShellSort {
    private ShellSort(){}
    public static <E extends Comparable<E>>void sort(@org.jetbrains.annotations.NotNull E[]arr){
        int h=arr.length/2;
        while(h>=1){
            for (int start = 0; start < h; start++) {

                //然后对[start,start+h-start+2h-start+3h排序
                for (int i = start; i < arr.length; i+=h) {
                    E t=arr[i];
                    int j;
                    for ( j = i; j-h>=0&&t.compareTo(arr[j-h])<0; j-=h) {
                        arr[j]=arr[j-h];
                    }
                    arr[j]=t;
                }
            }
            h/=2;
        }
    }
}