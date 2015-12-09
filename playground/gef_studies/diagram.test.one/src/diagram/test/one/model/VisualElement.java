package diagram.test.one.model;

import java.io.Serializable;

public class VisualElement implements Serializable {
	private static final long serialVersionUID = 685569623519412449L;
	
	public static final int DEFAULT_X = 0;
	public static final int DEFAULT_Y = 0;
	public static final int DEFAULT_WIDTH = 100;
	public static final int DEFAULT_HEIGTH = 100;
	private int x;
	private int y;
	private int width;
	private int height;
	
	public VisualElement() {
		setX(DEFAULT_X);
		setY(DEFAULT_Y);
		setHeight(DEFAULT_HEIGTH);
		setWidth(DEFAULT_WIDTH);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
