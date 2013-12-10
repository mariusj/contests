import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BlackAndWhiteGame {

    private static int SZ;

    private ArrayList<String> moves = new ArrayList<String>();

    private static class Point {
        int x, y;
        Group group;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj;
            return other.x == x && other.y == y;
        }

        @Override
        public int hashCode() {
            return x + (y << 16);
        }
    }

    private static class Group {
        ArrayList<Point> group;
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        int xc = -1;
        int yc = -1;

        public Group() {
            group = new ArrayList<Point>();
        }

        void add(Point p) {
            group.add(p);
            p.group = this;
            if (p.x < x1)
                x1 = p.x;
            if (p.x > x2)
                x2 = p.x;
            if (p.y < y1)
                y1 = p.y;
            if (p.y > y2)
                y2 = p.y;
            xc = x1 + (x2 - x1) / 2;
            yc = y1 + (y2 - y1) / 2;
        }
    }

    private static class Board {
        static final int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
        int[][] board;
        ArrayList<Point> whites = new ArrayList<Point>();
        ArrayList<Group> connected = new ArrayList<Group>();
        static final Comparator<Group> ccomp = new Comparator<Group>() {
            public int compare(Group o1, Group o2) {
                return o1.group.size() - o2.group.size();
            }
        };

        public Board(String[] src) {
            board = new int[SZ][SZ];
            for (int y = 0; y < SZ; y++)
                for (int x = 0; x < SZ; x++) {
                    board[y][x] = src[y].charAt(x) == 'X' ? 1 : 0;
                    if (board[y][x] == 1)
                        whites.add(new Point(x, y));
                }
        }

        /*
         * public Board(Board src) { board = new int[SZ][]; for (int y = 0; y <
         * SZ; y++) board[y] = Arrays.copyOf(src.board[y], SZ); }
         */

        void findConnected() {
            for (int y = 0; y < SZ; y++)
                for (int x = 0; x < SZ; x++)
                    if (board[y][x] == 1) {
                        newGroup(x, y);
                    }
            Collections.sort(connected, ccomp);
            for (int y = 0; y < SZ; y++)
                for (int x = 0; x < SZ; x++)
                    if (board[y][x] == 2)
                        board[y][x] = 1;
        }

        void newGroup(int x, int y) {
            Group group = new Group();
            connected.add(group);
            addToGroup(group, x, y);
        }

        void addToGroup(Group group, int x, int y) {
            board[y][x] = 2;
            Point p = new Point(x, y);
            int pidx = whites.indexOf(p);
            p = whites.get(pidx);
            group.add(p);
            for (int dir = 0; dir < 4; dir++) {
                if (get(x, y, dir) == 1) {
                    addToGroup(group, x + dc[dir], y + dr[dir]);
                }
            }
        }

        int get(int x, int y, int dir) {
            x += dc[dir];
            y += dr[dir];
            if (x < 0 || y < 0 || x >= SZ || y >= SZ)
                return -1;
            return board[y][x];
        }

        public void connect() {
            Group max = connected.get(connected.size() - 1);
            for (int i = 0; i < max.group.size(); i++)
                board[max.group.get(i).y][max.group.get(i).x] = 2;

            for (int i = 0; i < connected.size() - 2; i++) {
                Group g = connected.get(i);
                for (int j = 0; j < g.group.size(); j++) {
                    connect(g.group.get(j), max);
                }
            }

        }

        private void connect(Point point, Group max) {
            int dx1 = point.x - max.x1;
            int dy1 = point.y - max.y1;
            int dx2 = point.x - max.x2;
            int dy2 = point.y - max.y2;

            int dxc = point.x - max.xc;
            int dyc = point.y - max.yc;

            boolean blockx = false, blocky = false;

            if (max.x1 >= point.x && point.x <= max.x2)
                blockx = true;
            if (max.y1 >= point.y && point.y <= max.y2)
                blocky = true;
            if (blockx && blocky) {
                if (Math.abs(dxc) < Math.abs(dyc)) {
                    blockx = false;
                } else {
                    blocky = false;
                }
            }

            int dx = 0;
            if (point.x < max.xc)
                dx = -1;
            if (point.x > max.xc)
                dx = 1;
            if (point.x < max.x1)
                dx = -2;
            if (point.x > max.x2)
                dx = 2;

            int dy = 0;
            if (point.y < max.yc)
                dy = -1;
            if (point.y > max.yc)
                dy = 1;
            if (point.y < max.y1)
                dy = -2;
            if (point.y > max.y2)
                dy = 2;

        }

        char getChar(int x, int y) {
            switch (board[y][x]) {
            case 1:
                return 'X';
            case 2:
                return '@';
            }
            return '.';
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            for (int y = 0; y < SZ; y++) {
                for (int x = 0; x < SZ; x++) {
                    res.append(getChar(x, y));
                }
                res.append("\n");
            }
            return res.toString();
        }

    }

    String[] makeConnected(String[] board) {
        SZ = board.length;
        Board first = new Board(board);
        first.findConnected();
        first.connect();
        System.out.println();
        System.out.println(first.toString());
        return moves.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // BlackAndWhiteVis.main(new String[] { "-seed", "1", "-exec", "",
        // "-novis" });
        BlackAndWhiteVis.main(new String[] { "-seed", "1", "-exec", "" });
    }

}
