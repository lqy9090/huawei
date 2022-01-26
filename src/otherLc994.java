import java.util.LinkedList;
import java.util.Queue;

public class otherLc994 {
    public int orangesRottingFei(int[][] grid) {//向上传递失败
        int minute = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] gridJ = grid[i];
            for (int j = 0; j < gridJ.length; j++) {
                int type = grid[i][j];
                System.out.print("type: " + type);
               if (type == 2) {
                   int flag = 0;

                   if (i>0 ) {
                       if(grid[i - 1][j] ==1 ){
                           grid[i - 1][j] *= type;
                           flag = 1;
                       }
                       System.out.print(" d: "+grid[i - 1][j]);
                   }
                   if (i < grid.length - 1) {
                       if (grid[i + 1][j] == 1) {
                           flag = 1;
                           grid[i + 1][j] *= type;
                       }
                       System.out.print(" u: "+grid[i + 1][j]);
                   }

                   if (j >0 ) {
                       if(grid[i][j - 1] ==1 ) {
                           flag = 1;
                           grid[i][j - 1] *= type;
                       }
                       System.out.print(" l: "+ grid[i][j - 1]);
                   }
                   if (j < gridJ.length - 1) {
                       if (grid[i][j + 1] == 1) {
                           flag = 1;
                           grid[i][j + 1] *= type;
                       }
                       System.out.print(" r: " + grid[i][j + 1]);
                   }
                   if (flag == 1) minute++;
               }
                System.out.println();
            }
        }
        int flag  = 0;
        for (int[] gridJ : grid) {
            for (int i : gridJ) {
                if (i == 1) {
                    flag = 1;
                    break;
                }
            }
        }
        System.out.println("minute: " + minute);
        return flag == 1 ? -1 : minute;
    }

    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) { //新鲜橘子数初始化
                    count++;
                } else if (grid[r][c] == 2) { //腐烂的橘子的位置放在队列里面
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; //round表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {
            round++; //新鲜橘子有 并且有腐烂橘子
            int n = queue.size(); //腐烂橘子数
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
                if (r-1>=0 && grid[r-1][c] == 1) {//上边新鲜橘子被污染
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});//新增腐烂橘子
                }
                if (r + 1 < M && grid[r + 1][c] == 1) {//下
                    grid[r+1][c] = 2;
                    count --;
                    queue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {//左
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < N && grid[r][c + 1] ==1) {//右
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
            }

        }

        return count > 0 ? -1 : round;
    }

    public static void main(String[] args) {
        otherLc994 solution = new otherLc994();
//        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] grid = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
//        int[][] grid = new int[][]{{0, 2}};
        int[][] grid = new int[][]{{2,0,1,1,1,1,1,1,1,1},{1,0,1,0,0,0,0,0,0,1},{1,0,1,0,1,1,1,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}};
        int i = solution.orangesRotting(grid);
        System.out.println(i);
    }
}
