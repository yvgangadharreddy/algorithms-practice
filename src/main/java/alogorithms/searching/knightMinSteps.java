package alogorithms.searching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Cell {
    int x;
    int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class knightMinSteps {

    public static int findMinSteps(Cell cur, Cell tar) {
        int[][] dis = new int[9][9];
        int[][] dirs = {{-1,-2}, {-1,2}, {-2,-1}, {-2,1}, {1,-2}, {1,2}, {2,-1}, {2,1}};
        for (int[] x: dis)
            Arrays.fill(x, -1);
        Queue<Cell> q = new LinkedList<>();
        q.add(cur);
        dis[cur.x][cur.y] = 0;
        while (!q.isEmpty()) {
            Cell t = q.remove();
            if (t.x == tar.x && t.y == tar.y)
                return dis[t.x][t.y];
            for (int[] dir: dirs) {
                Cell v = new Cell(t.x + dir[0], t.y + dir[1]);
                if (isInside(v) && dis[v.x][v.y] == -1) {
                    q.add(v);
                    dis[v.x][v.y] = dis[t.x][t.y] + 1;
                }
            }
        }
        return -1;
    }

    private static boolean isInside(Cell v) {
        return v.x >= 1 && v.x <= 8 && v.y >= 1 && v.y <= 8;
    }

    public static void main(String[] args) {
        Cell cur = new Cell(1, 1);
        Cell tar = new Cell(3,5);
        System.out.println(findMinSteps(cur, tar));
    }
}
