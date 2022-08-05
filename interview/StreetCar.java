package interview;
// https://www.1point3acres.com/bbs/thread-915524-1-1.html
import java.util.*;


public class StreetCar {
  public int[] solution(int[] time, int[] road) {

    int lastRoad = 1;  // initialize last road as 1st street
    int curTime = 0;
    int[] res = new int[road.length];

    for (int i = 0; i < road.length - 1; i++) {
      if (curTime == time[i] && curTime == time[i+1]) {
        if (road[i] == road[i + 1]) { // 是同一条路上的车，数组前面的先走
          res[i] = curTime++;
          lastRoad = road[i];
          time[i+1]++;
        } else {  // 不是同一条路上的车，看上一次过的是哪条路的车
          // 如果上一秒没有车经过 || 上一次过的是 1st street，那这一秒 1st Avenue的车通行
          if (lastRoad == 1) {
            if (road[i] > road[i+1]) {  // 值大的是 1st Avenue
              res[i] = curTime++;
              lastRoad = road[i];
              time[i+1]++;
            } else if (road[i] < road[i+1]) {
              res[i+1] = curTime++;
              lastRoad = road[i+1];
              time[i]++;
              swap(time, i, i+1);  // swap i to i+1 position for both time and road array, because car at i position don't pass, but i will plus 1
              swap(road, i, i+1);
              swap(res, i, i+1);
            }
          } else if (lastRoad == 0) {
            if (road[i] < road[i+1]) {
              res[i] = curTime++;
              lastRoad = road[i];
              time[i+1]++;
            } else if (road[i] > road[i+1]) {
              res[i+1] = curTime++;
              lastRoad = road[i+1];
              time[i]++;
              swap(time, i, i+1);  // swap i to i+1 position for both time and road array, because car at i position don't pass, but i will plus 1
              swap(road, i, i+1);
              swap(res, i, i+1);
            }
          }
        }
      } else {
        
      }
    }
    return res;
  }

  private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void main(String[] args) {
    StreetCar sol = new StreetCar();
    int[] result = sol.solution(new int[]{0, 0, 1, 4}, new int[]{0, 1, 1, 0});
    System.out.println(Arrays.toString(result));
  }
}
