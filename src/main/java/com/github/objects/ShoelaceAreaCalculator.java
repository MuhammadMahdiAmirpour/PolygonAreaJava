package com.github.objects;

public class ShoelaceAreaCalculator implements AreaCalculator {
	@Override
	public double calculateArea(double[][] points) {
		int n = points.length;
		double area = 0.0;

		for (int i = 0; i < n; i++) {
			int j = (i + 1) % n; // Next vertex index
			area += points[i][0] * points[j][1]; // x_i * y_(i+1)
			area -= points[j][0] * points[i][1]; // x_(i+1) * y_i
		}

		return Math.abs(area) / 2.0; // Return the absolute value of area divided by 2
	}
}
