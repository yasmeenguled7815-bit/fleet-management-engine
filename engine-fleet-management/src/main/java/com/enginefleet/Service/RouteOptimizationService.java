package com.enginefleet.Service;

import org.springframework.stereotype.Service;

import com.enginefleet.DTO.Coordinate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteOptimizationService {

	public List<Coordinate> optimize(List<Coordinate> stops) {

		List<Coordinate> optimized = new ArrayList<>();

		if (stops.isEmpty())
			return optimized;

		Coordinate current = stops.get(0);
		optimized.add(current);

		List<Coordinate> remaining = new ArrayList<>(stops);
		remaining.remove(0);

		while (!remaining.isEmpty()) {

			Coordinate nearest = remaining.get(0);
			double minDistance = distance(current, nearest);

			for (Coordinate c : remaining) {

				double d = distance(current, c);

				if (d < minDistance) {
					minDistance = d;
					nearest = c;
				}
			}

			optimized.add(nearest);
			remaining.remove(nearest);
			current = nearest;
		}

		return optimized;
	}

	private double distance(Coordinate a, Coordinate b) {

		double dx = a.getLatitude() - b.getLatitude();
		double dy = a.getLongitude() - b.getLongitude();

		return Math.sqrt(dx * dx + dy * dy);
	}
}
