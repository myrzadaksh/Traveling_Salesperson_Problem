# Traveling Salesperson Problem (TSP)

## Overview

This project implements a solution to the Traveling Salesperson Problem (TSP) using a circularly linked list to represent tours. The goal of TSP is to determine the shortest possible route that visits a given set of points exactly once and returns to the starting point.

## Key Features

1) Representation of the TSP tour as a circularly linked list.

2) Two heuristic approaches to approximate solutions:

- Nearest Neighbor Insertion: Adds points to the tour by selecting the closest point to an existing one.
  
- Smallest Increase Insertion: Adds points to the tour at the position that results in the smallest increase in tour length.
  
3) Visualization of the tour using the StdDraw library.

4) Calculation of tour properties:

- Number of points in the tour.
  
- Total length of the tour.

## Files

- Point.java: Represents a 2D point with methods for calculating distances, drawing points, and drawing lines.
  
- Tour.java: Implements the circularly linked list to manage the TSP tour and provides methods for nearest neighbor and smallest increase heuristics.
  
- NearestInsertion.java: Client program to demonstrate the nearest neighbor heuristic.
  
- SmallestInsertion.java: Client program to demonstrate the smallest increase heuristic.

## How to Run

1) Compile the Code:

javac Point.java Tour.java NearestInsertion.java SmallestInsertion.java

2) Run Nearest Neighbor Heuristic:

java NearestInsertion < input.txt

3) Run Smallest Increase Heuristic:

java SmallestInsertion < input.txt

## Output

The program outputs:

- The points in the tour, in the order they are visited.
  
- The total length of the tour.
  
- The number of points in the tour.

## Future Improvements

1) Implement more advanced heuristics, such as:
   
- Christofides' algorithm.
  
- Genetic algorithms.
  
- Simulated annealing.
  
2)Extend support for saving and loading tours from a file.

3)Optimize the program for larger datasets.

## Acknowledgments

This project is inspired by real-world combinatorial optimization problems and demonstrates heuristic approaches to solve complex problems efficiently.

