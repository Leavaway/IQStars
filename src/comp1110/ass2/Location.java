package comp1110.ass2;

public class Location {
    //Authored by Zichen Zhang.
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location() {
        this.x = -1;
        this.y = -1;
    }

    public boolean onBoard(){
        if (y == 0||y == 2){
            if (0 <= x&&x <= 6){
                return true;
            }
        }

        if (y == 1||y == 3){
            if (0 <= x&&x <= 5){
                return true;
            }
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + "" + this.y;
    }
}
