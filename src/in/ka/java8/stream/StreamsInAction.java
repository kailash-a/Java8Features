package in.ka.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsInAction {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		
		System.out.println("==>Find all transactions in the year 2011 and sort them by value (small to high) ");
		transactions.stream()
					.filter(transaction -> transaction.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.forEach(System.out::println);
					// .collect(Collectors.toList());
		
		System.out.println("\n==>What are all the unique cities where the traders work?");
		transactions.stream()
					.map(transaction -> transaction.getTrader().getCity())
					.distinct()
					.forEach(System.out::println);
		
		System.out.println("\n==>Find all traders from Cambridge and sort them by name.");
		transactions.stream()
					.map(Transaction::getTrader)
					.filter(trader -> trader.getCity().equals("Cambridge"))
					.distinct()
					.sorted(Comparator.comparing(Trader::getName))
					.forEach(System.out::println);
		
		System.out.println("\n==>Return a string of all trader's names sorted alphabetically");
		transactions.stream()
					.map(Transaction::getTrader)
					.map(trader -> trader.getName())
					.distinct()
					.sorted()
					.forEach(System.out::println);
		
		System.out.println("\n==>Are any traders based in Milan?");
		boolean anyInMilan=transactions.stream()
					.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
		System.out.println(anyInMilan);
		
		System.out.println("\n==>Print all transactions’ values from the traders living in Cambridge");
		transactions.stream()
					.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue)
					.forEach(System.out::println);
		
		System.out.println("\n==> What’s the highest value of all the transactions?");
		Optional<Integer> max=transactions.stream()
					.map(Transaction::getValue)
					.reduce(Integer::max);
		System.out.println(max.get());
		
		
		
	}

}
