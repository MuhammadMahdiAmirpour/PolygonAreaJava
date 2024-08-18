package com.github.factory;

import com.github.objects.AreaCalculator;
import com.github.objects.Polygon;
import com.github.objects.ShoelaceAreaCalculator;

import java.util.List;

public class PolygonFactory {

	public static Polygon createPolygon(List<double[]> points) {
		AreaCalculator areaCalculator = new ShoelaceAreaCalculator();
		return new Polygon(points, areaCalculator);
	}
}
