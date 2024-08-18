package com.github.objects;

import com.github.exception.PolygonCreationException;

import java.util.List;

public class Polygon {
	private final List<double[]> points;
	private final AreaCalculator areaCalculator;

	public Polygon(List<double[]> points, AreaCalculator areaCalculator) {
		if (points.size() < 3) {
			throw new PolygonCreationException("A polygon must have at least 3 vertices.");
		}
		this.points = points;
		this.areaCalculator = areaCalculator;
	}

	public double getArea() {
		return areaCalculator.calculateArea(points.toArray(new double[0][0]));
	}
}
