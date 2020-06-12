package pt.adentis.api.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

class FizzBuzz 
{ 
	 private static final String NUMERO = "\\d+";
	 	
	    /**
	     * prepare the output with right value
	     * 
	     * @return Returns a sequential fizz, buzz, fizzbuzz and the number itself
	     */
	    public String Start() {
	        return IntStream.rangeClosed(1, 20)
	                .parallel()
	                .mapToObj(i -> i % 15 == 0 ? "fizzbuzz" : i % 3 == 0 ? "fizz" : i % 5 == 0 ? "buzz" : Integer.toString(i))
	                .collect(joining(" "));
	    }
	    
	    /**
	     * create a real sequence of data, with a sequence of primitive int-valued 
	     * elements supporting sequential and parallelaggregate operations
	     * 
	     * @return fizz, buzz, fizzbuzz or the number itself
	     */
	    public String Validator() {
	    	 return IntStream.rangeClosed(1, 20)
	    	            .parallel().mapToObj(i -> 
	    	                Integer.toString(i).contains("3") 
	    	                    ? "lucky" : i % 15 == 0 
	    	                        ? "fizzbuzz" : i % 3 == 0 
	    	                            ? "fizz" : i % 5 == 0 
	    	                                ? "buzz" : Integer.toString(i)).collect(joining(" "));
	    }
	    

	    /**
	     * OutPut, get Start and Validator to processing the return.
	     * 
	     * @return fizz, buzz, fizzbuzz or the number itself
	     */
	    public String outPut() {
	        List<String> fizzBuzzList = IntStream.rangeClosed(1, 20)
	                .parallel()
	                .mapToObj(i -> Integer.toString(i).contains("3") ? "lucky"
	                        : i % 15 == 0 ? "fizzbuzz"
	                        		: i % 3 == 0 ? "fizz"
	                        				: i % 5 == 0 ? "buzz"
	                        						: Integer.toString(i)).collect(Collectors.toList());

	        Map<String, Long> countMap = fizzBuzzList
	                .parallelStream().collect(groupingBy(s -> s.matches(NUMERO) ? "integer" : s, counting()));

	        String fizzbuzz = fizzBuzzList.parallelStream().collect(joining(" "));

	        String counts = countMap.entrySet().parallelStream()
	                .map(e -> e.getKey() + ": " + e.getValue())
	                .collect(joining("\n"));

	        return fizzbuzz + "\n" + counts;
	    }
	    
	    
} 