package back;

public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Pos(Pos pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public boolean compare(Pos pos) {
        return x == pos.x && y == pos.y;
    }
}
