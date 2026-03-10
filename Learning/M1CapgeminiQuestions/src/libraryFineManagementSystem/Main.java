package libraryFineManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

class Member {
	int outstanding;
	int totalImposed;
	int totalPaid;

	Member() {
		outstanding = 0;
		totalImposed = 0;
		totalPaid = 0;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();

		HashMap<String, Member> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");
			String command = parts[0];

			if (command.equals("ADD")) {
				String id = parts[1];
				if (!map.containsKey(id)) {
					map.put(id, new Member());
				}
			}

			else if (command.equals("IMPOSE")) {
				String id = parts[1];
				int amount = Integer.parseInt(parts[2]);

				if (map.containsKey(id)) {
					Member m = map.get(id);
					m.outstanding += amount;
					m.totalImposed += amount;
				}
			}

			else if (command.equals("PAY")) {
				String id = parts[1];
				int amount = Integer.parseInt(parts[2]);

				if (map.containsKey(id)) {
					Member m = map.get(id);

					int actualPay = Math.min(amount, m.outstanding);
					m.outstanding -= actualPay;
					m.totalPaid += actualPay;
				}
			}

			else if (command.equals("DETAILS")) {
				String id = parts[1];

				if (map.containsKey(id)) {
					Member m = map.get(id);
					System.out.println(id + " " + m.outstanding + " " + m.totalImposed + " " + m.totalPaid);
				} else {
					System.out.println("Member Not Found");
				}
			}
		}

		sc.close();
	}
}