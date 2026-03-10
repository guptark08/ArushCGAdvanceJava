package stockPriceManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static Map<String, List<Integer>> ls = new HashMap<>();

	public static void addStock(String stockName, int price) {
		if (!ls.containsKey(stockName)) {
			ls.put(stockName, new ArrayList<>());
		}
		ls.get(stockName).add(price);

	}

	public static void getHighestPrice(String stockName) {
		if (!ls.containsKey(stockName) || ls.get(stockName).isEmpty()) {
			System.out.println("No data");
			return;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ls.get(stockName).size(); i++) {
			if (ls.get(stockName).get(i) > max) {
				max = ls.get(stockName).get(i);
			}
		}
		System.out.printf("%.2f\n", (double) max);
	}

	public static void removeStock(String stockName) {
		System.out.println(ls.remove(stockName));
	}

	public static void getStockTrend(String stockName) {

		if (!ls.containsKey(stockName) || ls.get(stockName).isEmpty()) {
			System.out.println("No data");
			return;
		}

		List<Integer> prices = ls.get(stockName);

		if (prices.size() == 1) {
			System.out.println("Stable");
			return;
		}

		boolean increasing = true;
		boolean decreasing = true;
		boolean allEqual = true;

		for (int i = 0; i < prices.size() - 1; i++) {

			int curr = prices.get(i);
			int next = prices.get(i + 1);

			if (next > curr) {
				decreasing = false;
				allEqual = false;
			} else if (next < curr) {
				increasing = false;
				allEqual = false;
			} else {
				increasing = false;
				decreasing = false;
			}
		}

		if (allEqual)
			System.out.println("Stable");
		else if (increasing)
			System.out.println("Increasing");
		else if (decreasing)
			System.out.println("Decreasing");
		else
			System.out.println("Mixed");

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		while (n-- > 0) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");
			String operation = parts[0];
			String name = parts[1];

			switch (operation) {
			case "addStockPrice":
				int price = Integer.parseInt(parts[2]);
				addStock(name, price);
				break;
			case "getStockTrend":
				getStockTrend(name);
				break;
			case "removeStock":
				removeStock(name);
				break;
			case "getHighestPrice":
				getHighestPrice(name);
				break;
			}
		}
	}
}
