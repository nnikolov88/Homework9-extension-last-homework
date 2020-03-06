package informatics.fmi.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;
import junit.framework.Assert;

public class ConcatenateTest {

	public String concatenate(String one, String two) {
		return one + two;
	}

	@Test
	public void testConcatenate() {
		String result = concatenate("one", "two");
		String expectedResult = "onetwo";

		assertEquals(expectedResult, result);
	}

	@Test
	public void testConcatenateFailed() {
		fail("Not yet implemented!");
	}
	
	@Test
	public void test1() {		
		ArrayList<String> animals = new ArrayList<String>();
		Stream.of("cat", "dog", "cow", "bird") 
		.map(String::toUpperCase)
		.sorted()
		.collect(Collectors.toList()) 
		.forEach(s -> animals.add(s)); 

		 
		Assert.assertEquals(animals.get(0),"dog");

	}
	@Test
	public void test2() {		
	
		IntStream.iterate(0, i -> i + 1)
		.skip(5)
		.limit(10)
		.forEach(i -> { 
			if (i % 2 == 0) 
				System.out.println(i);						
			});

		
	}
	

	@Test
	public void test3() {		
		ArrayList<Student> students = new ArrayList<Student>();
		Stream.of(Student.StudentGenerator.make(),
			Student.StudentGenerator.make(),
			Student.StudentGenerator.make()
			)
	.filter(s -> s.getName().length() > 4)
	.sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
	.forEach(s -> students.add(s)); 
		
	 Assert.assertEquals(students.get(0).getName().toString(),"Danail");
	}
	
	@Test
	public void testRock() {		
		Rock onEarth = new Rock();
		onEarth.drop(onEarth.height());
		Rock onMars = new Rock();

		assertEquals(onEarth,onMars);
	
	}
	
}
