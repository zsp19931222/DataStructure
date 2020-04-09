@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        System.out.println("顺序表查找算法==========>" + Sequential_Search(datas, 10));
        System.out.println("顺序表查找算法（优化）==========>" + Sequential_Search2(datas, 10));
        System.out.println("二分查找==========>" + Binary_Search(BinaryDatas, 3));
        System.out.println("二分查找==========>" + Binary_Search2(BinaryDatas, 6));
    }

    /*
     * @description:顺序表查找算法
     * @author: Andy
     * @date: 2020/4/9 0009 16:18
     * @param null:
     * @return:
     */

    private static int[] datas = {0, 9, 7, 55, 99, 2, 3, 6, 5};

    private static int Sequential_Search(int[] datas, int key) {
        for (int i = 0; i < datas.length; i++) {
            if (datas[i] == key) {
                return i;
            }
        }
        return 0;
    }

    private static int Sequential_Search2(int[] datas, int key) {
        int i;
        datas[0] = key;//设置datas[0]为关键字，哨兵
        i = datas.length - 1;
        while (datas[i] != key) {
            i--;
        }
        return i;
    }


    /*
     * @description: 二分查找(有序的情况下能用)
     * @author: Andy
     * @date: 2020/4/9 0009 16:41
     * @param null:
     * @return:
     */
    private static int[] BinaryDatas = {0, 1, 3, 6, 10, 55};

    private static int Binary_Search(int[] datas, int key) {
        int low = 0, heigh = datas.length - 1, mid;
        while (low <= heigh) {
            mid = (low + heigh) / 2;
            if (key < datas[mid]) {
                heigh = mid - 1;
            } else if (key > datas[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return 0;
    }

    /*
     * @description:插值查找
     * @author: Andy
     * @date: 2020/4/9 0009 17:17
     * @param null:
     * @return:
     */
    private static int Binary_Search2(int[] datas, int key) {
        int low = 0, heigh = datas.length - 1, mid;
        while (low <= heigh) {
            mid = low + (heigh - low) * (key - datas[low]) / (datas[heigh] - datas[low]);
            if (key < datas[mid]) {
                heigh = mid - 1;
            } else if (key > datas[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }
}