package com.github;

import com.github.config.Configuration;
import com.github.exception.PolygonCreationException;
import com.github.factory.PolygonFactory;
import com.github.objects.Polygon;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		try {
			List<double[]> points = generateRandomPoints();

			// Create a polygon using the factory
			Polygon polygon = PolygonFactory.createPolygon(points);

			// Calculate and output the area
			double area = polygon.getArea();
			logger.info(String.format("The area of the polygon with random points is: %.2f", area));
		} catch (PolygonCreationException e) {
			logger.severe("Error creating polygon: " + e.getMessage());
		}
	}

	// Method to generate random points within specified limits for x and y
	private static List<double[]> generateRandomPoints() {
		Random random = new Random();
		List<double[]> points = new ArrayList<>();

		for (int i = 0; i < Configuration.NUMBER_OF_VERTICES; i++) {
			double[] point = new double[2];
			point[0] = Configuration.X_MIN + (Configuration.X_MAX - Configuration.X_MIN) * random.nextDouble(); // Random x-coordinate within limits
			point[1] = Configuration.Y_MIN + (Configuration.Y_MAX - Configuration.Y_MIN) * random.nextDouble(); // Random y-coordinate within limits
			points.add(point);
		}
		return points;
	}
}
