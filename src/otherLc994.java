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
        int minute = 0;
        return minute;
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
