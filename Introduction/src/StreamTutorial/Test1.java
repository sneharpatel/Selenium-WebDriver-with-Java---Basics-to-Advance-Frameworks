package StreamTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
	
	//count the number of names starting with alphabet A in list
	
	//@Test
	public void regular() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhinav");
		names.add("Don");
		names.add("Adam");
		names.add("Alekhya");
		names.add("Ram");
		
		int count = 0;
		
		for(int i=0; i<names.size(); i++) {
			String name = names.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhinav");
		names.add("Don");
		names.add("Adam");
		names.add("Alekhya");
		names.add("Ram");
		
		// There is no life of intermediate operator (i.e filter) if there is no terminal operator (i.e count())
		// Terminal operation will execute only when intermediate op returns true
		// We can create stream
		// We can use filter in stream API
		
		long c = names.stream().filter(s->s.startsWith("A")).count();
		//System.out.println(c);
		
		long d = Stream.of("Abhinav","Don", "Adam", "Alekhya", "Ram").filter(s->
		{
			s.startsWith("A");
			return true;
			
		}).count();
		
			System.out.println(d); // this should return 3 instead that returns 5
			
			// print all the names of ArrayList
			names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
			
			// print only 1 from the names of ArrayList based on given condition
			
			names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
	}
	
	@Test
	public void streamMap() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("kid");
		names.add("woman");
		
		// map is used when need to modify list
		
		// print the names which have last letter 'a' with upper-case letter
		
		Stream.of("Abhinav","Don", "Adam", "Alekhya", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		
		// print the names which have first letter as a with upper case and sorted
		
		List<String>list = Arrays.asList("Abhinav","Don", "Adam", "Alekhya", "Rama");
		
		list.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		// Merging two different strings and then sort
		
		Stream<String> newName = Stream.concat(names.stream(), list.stream()); // merging of two strings
		
		//newName.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newName.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag); // test will pass only when flag is true otherwise it will fail
		
		
	}
	
	@Test
	public void streamCollect() {
		
		List<String> ls = Stream.of("Abhinav","Don", "Adam", "Alekhya", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
		List<Integer> values = Arrays.asList(3,6,2,7,9,8,5,7,3);
		
		// print unique numbers from the array
		// sort the array and get 3rd index (2, 3, 5, 6, 7, 8 ,9)
		
		//values.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> values1 = values.stream().distinct().sorted().collect(Collectors.toList()); 
		System.out.println(values1.get(2));
	}
	
	

}
