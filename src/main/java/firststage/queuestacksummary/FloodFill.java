package firststage.queuestacksummary;

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (newColor != oldColor)
            changeColor(image, sr, sc, oldColor, newColor);
        return image;
    }

    public void changeColor(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0
                || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        changeColor(image, sr - 1, sc, oldColor, newColor);
        changeColor(image, sr + 1, sc, oldColor, newColor);
        changeColor(image, sr, sc - 1, oldColor, newColor);
        changeColor(image, sr, sc + 1, oldColor, newColor);
    }


}
