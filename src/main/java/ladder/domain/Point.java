package ladder.domain;

import java.util.Objects;

public class Point {
    private final int position;

    public Point(int position, int countOfPerson) {
        if (position < 0 || position >= countOfPerson) {
            throw new IllegalArgumentException("좌표를 벗어났습니다.");
        }

        this.position = position;
    }

    public int compareToPosition(int position) {
        return Integer.compare(this.position, position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
