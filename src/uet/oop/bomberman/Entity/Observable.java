package uet.oop.bomberman.Entity;

interface Observable {
    /**
     * render lại Entity mỗi game loop.
     */
    default void update() {

    }

    /**
     * Gọi khi mà một thực thể bị phá hủy.
     */
    default void onDestroy() {

    }

    int compareTo(Entity o);
}
