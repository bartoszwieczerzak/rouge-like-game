package bwgames;

public class GameMath {

    public static int clamp(int value, int min, int max) {
        if (value < min) value = min;
        if (value > max) value = max;

        return value;
    }

    public static int clampMin(int value, int min) {
        if (value < min) value = min;

        return value;
    }

    public static float clampMin(float value, float min) {
        if (value < min) value = min;

        return value;
    }

    public static int clampMax(int value, int max) {
        if (value > max) value = max;

        return value;
    }

    public static float clampMax(float value, float max) {
        if (value > max) value = max;

        return value;
    }

    public static int clamp01(int value) {
        if (value < 0) value = 0;
        if (value > 1) value = 1;

        return value;
    }
}
