package com.mihir.tower_of_hanoi;

import java.util.List;
import java.util.Scanner;


public class ShiftDiscs {
static int inputSize;	
static pedestal source;
static pedestal destination;
static pedestal auxillary;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of Discs: ");
		source = new pedestal("source");
		auxillary = new pedestal("auxiallary");
		destination = new pedestal("destination");
		inputSize = scan.nextInt();
		for (int i = inputSize; i > 0; i--) {
			disc d = new disc(i, Integer.toString(i));
			addNewDisc(source, d);
		}

		// print no of moves
		System.out.println("Number of moves made: " + noOfMoves(source, destination, auxillary, source.getDiscList().size()));
		scan.close();
	}

	static void addNewDisc(pedestal p, disc d) {
		p.getDiscList().push(d);
	}

	static void printState(pedestal source, pedestal auxillary, pedestal destination, int n) {
		System.out.println("source\tauxillary\tdestination");
		List<disc> sourceList = source.getDiscList();
		List<disc> auxillaryList = auxillary.getDiscList();
		List<disc> destinationList = destination.getDiscList();
		for (int i = n; i > 0; i--) {
			StringBuffer line = new StringBuffer();
			if(sourceList.size()<i) {
				line.append("-\t");
			}else {
				line.append(sourceList.get(i-1).size+"\t");
			}
			if(auxillaryList.size()<i) {
				line.append("-\t\t");
			}else{
				line.append(auxillaryList.get(i-1).size+"\t\t");
			}
			if(destinationList.size()<i) {
				line.append("-");
			}else{
				line.append(destinationList.get(i-1).size);
			}
			System.out.println(line);
		}
	}

	static int shift(pedestal p1, pedestal p2) {
		if (p2.getDiscList().size() > 0 && p1.getDiscList().size() > 0) {
			if (p2.getDiscList().peek().size > p1.getDiscList().peek().size) {
				p2.getDiscList().push(p1.getDiscList().pop());
				printState(source, auxillary, destination, inputSize);
				return 1;
			} else {
				System.out.println("no");
			}
		} else if (p1.getDiscList().size() > 0) {
			p2.getDiscList().push(p1.getDiscList().pop());
			printState(source, auxillary, destination, inputSize);
			return 1;
		}
		return 0;
	}

	static int noOfMoves(pedestal source, pedestal destination, pedestal auxillary, int no_Of_Discs) {
		int moves = 0;
		if (no_Of_Discs == 2) {
			moves += shift(source, destination);
			moves += shift(source, auxillary);
			moves += shift(destination, auxillary);
			return moves;
		} else if (no_Of_Discs == 3) {
			moves += noOfMoves(source, destination, auxillary, no_Of_Discs - 1);
			moves += shift(source, destination);
			moves += noOfMoves(auxillary, source, destination, no_Of_Discs - 1);
			return moves;
		}
		moves += noOfMoves(source, auxillary, destination, no_Of_Discs - 1);
		moves += shift(source, destination);
		moves += noOfMoves(auxillary, destination, source, no_Of_Discs - 1);
		return moves;
	}

}
