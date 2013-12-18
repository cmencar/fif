package test;



import java.net.URI;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fif_core.Attribute;
import fif_core.DescriptionBasedFilter;
import fif_core.Descriptor;
import fif_core.FuzzySet;
import fif_core.Metadata;
import fif_core.PossibilisticInterpretation;
import fif_core.Resource;
import fif_core.ResourceRegister;



public class PossibilisticInterpretationTester extends TestCase {
	
	
	Attribute att1;
	FuzzySet fs1=new FuzzySet();
	FuzzySet fs2=new FuzzySet();
	Metadata m;
	Metadata m2;
	Descriptor d;
	Resource r;
	ResourceRegister rr;
	DescriptionBasedFilter f1;

	@Before
	public void setUp() throws Exception {
		
		att1=new Attribute("attore");
		
		m=new Metadata(att1,fs1,PossibilisticInterpretation.getinstance());
		m2=new Metadata(att1,fs2,PossibilisticInterpretation.getinstance());
		
		d=new Descriptor();
		try {
			d.setMetadata(m2);
		} catch (Exception e) {

		}

		r=new Resource (new URI("ff"));
		
		rr= ResourceRegister.getinstance();
		rr.associateDescriptor(r, d);
		
		
		
		f1=new DescriptionBasedFilter(m);
		

		
		super.setUp();
	}
	
	@Test
	public void test1() throws Exception {
		
		
		//disgiunzione
		
		for(String s: fs1.getSupport()){

			fs1.removeElement(s);
		}
		
		
		fs1.setValue("damon", 0.8);
		fs1.setValue("kidman", 0.30);
		fs1.setValue("smith", 0.8);
		
		
		
		fs2.setValue("clooney", 0.4);
		fs2.setValue("stallone", 0.35);
		fs2.setValue("cruise", 0.43);
		fs2.setValue("hanks", 0.2);
		
		
		assertTrue(f1.doFilter(r)==0.0);
	}
	
	
	@Test
	public void test2() throws Exception {
		
		//intersezione
		
		for(String s: fs1.getSupport()){

			fs1.removeElement(s);
		}
		
		for(String s: fs2.getSupport()){

			fs2.removeElement(s);
		}
		
		
		fs1.setValue("clooney", 0.8);
		fs1.setValue("stallone", 0.30);
		fs1.setValue("damon", 0.37);
		
		
		
		fs2.setValue("clooney", 0.4);
		fs2.setValue("stallone", 0.35);		
		fs2.setValue("hanks", 0.2);
		
		assertTrue(f1.doFilter(r)==0.4);
	}
	
	@Test
	public void test3() throws Exception {
		
		//a incluso in b
		
		for(String s: fs1.getSupport()){

			fs1.removeElement(s);
		}
		for(String s: fs2.getSupport()){

			fs2.removeElement(s);
		}
		
		
		fs1.setValue("clooney", 0.8);
		fs1.setValue("stallone", 0.30);
		fs1.setValue("hanks", 0.8);
		fs1.setValue("cruise", 0.43);

		
		
		fs2.setValue("kidman", 1);
		fs2.setValue("clooney", 0.4);
		fs2.setValue("stallone", 0.35);
		fs2.setValue("cruise", 0.48);
		fs2.setValue("hanks", 0.2);
		
		assertTrue(f1.doFilter(r)==0.43);
	}
	

	@Test
	public void test4() throws Exception {
		
		//b incluso in a
		
		for(String s: fs1.getSupport()){

			fs1.removeElement(s);
		}
		
		for(String s: fs2.getSupport()){

			fs2.removeElement(s);
		}
		
		
		fs1.setValue("clooney", 0.75);
		fs1.setValue("stallone", 0.30);
		fs1.setValue("hanks", 0.8);
		fs1.setValue("kidman", 1);
		fs1.setValue("damon", 0.46);
		fs1.setValue("cruise", 0.58);
		
		
		
		fs2.setValue("clooney", 0.4);
		fs2.setValue("stallone", 0.35);
		fs2.setValue("cruise", 0.43);
		fs2.setValue("hanks", 0.34);
		
		assertTrue(f1.doFilter(r)==0.43);
	}
	
	
	@Test
	public void test5() throws Exception {
		
		//concidenza degli insiemi con valori diversi
		
		for(String s: fs1.getSupport()){

			fs1.removeElement(s);
		}
		
		for(String s: fs2.getSupport()){

			fs2.removeElement(s);
		}
		
		
		fs1.setValue("clooney", 0.8);
		fs1.setValue("stallone", 0.30);			
		fs1.setValue("cruise", 0.58);
		fs1.setValue("hanks", 0.8);			
		
		
		fs2.setValue("clooney", 0.4);
		fs2.setValue("stallone", 0.35);
		fs2.setValue("cruise", 0.43);
		fs2.setValue("hanks", 0.2);
		
		
		assertTrue(f1.doFilter(r)==0.43);
	}
	
	
	
	@Test
	public void test6() throws Exception {
		
		//concidenza degli insiemi con gli stessi valori
		
		for(String s: fs1.getSupport()){

			fs1.removeElement(s);
		}
		
		for(String s: fs2.getSupport()){

			fs2.removeElement(s);
		}
		
		
		fs1.setValue("clooney", 1);
		fs1.setValue("stallone", 0.30);			
		fs1.setValue("cruise", 0.58);
		fs1.setValue("hanks", 0.8);			
		
		
		fs2.setValue("clooney", 1);
		fs2.setValue("stallone", 0.35);
		fs2.setValue("cruise", 0.43);
		fs2.setValue("hanks", 0.2);
		
		
		assertTrue(f1.doFilter(r)==1);
	}
	


	

	@After
	public void tearDown() throws Exception {
		
		super.tearDown();
	}



}
