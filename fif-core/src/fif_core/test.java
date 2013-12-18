package fif_core;


import java.net.URI;
import java.net.URISyntaxException;



import fif_core.interfaces.Aggregator;





public class test {
	
	public static void main(String[] Args) throws URISyntaxException{
		

		
		
		double array[]={0,1,0.5};
		double array2[]={0,1,0.5};
		Aggregator a = new OWA(array);
		a.aggregate(array2);
		FuzzySet fs1=new FuzzySet();
		
		fs1.setValue("clooney", 0.8);
		fs1.setValue("stallone", 0.30);
		fs1.setValue("hanks", 0.8);
		
		FuzzySet fs2=new FuzzySet();
		
		fs2.setValue("clooney", 0.4);
		fs2.setValue("stallone", 0.35);
		fs2.setValue("cruise", 0.43);
		fs2.setValue("hanks", 0.2);
		
		
		
		
		Attribute att1=new Attribute("attore");
		Metadata m=new Metadata(att1,fs1,ClosedVeristicInterpretation.getinstance());
		Metadata m2=new Metadata(att1,fs2,ClosedVeristicInterpretation.getinstance());
		
		//URI r=new URI(null);
		Descriptor d=new Descriptor();
		try {
			d.setMetadata(m2);
		} catch (Exception e) {

		}

		Resource r=new Resource (new URI("ff"));
		
		ResourceRegister rr= ResourceRegister.getinstance();
		rr.associateDescriptor(r, d);
		
		
		
		DescriptionBasedFilter f1=new DescriptionBasedFilter(m);
		
		try {
			System.out.println(f1.doFilter(r));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		DescriptionBasedFilter f2=new DescriptionBasedFilter(m);
		DescriptionBasedFilter f3=new DescriptionBasedFilter(m);
		DescriptionBasedFilter f4=new DescriptionBasedFilter(m);
		ParallelFilter p=new ParallelFilter (a,f1,f2);
		p.getAllFilters().set(4, f3);
		//Resource r=new Resource(null);
		
		/*try {	
		
		
		
		Descriptor d=new Descriptor();
		FuzzySet fs1=new FuzzySet();
		
			Aggregator a = null;
			
			double array[]=new double[0];
			a = new OWA(null);
		
		fs1.setValue("gg", 0.1);
		Attribute att1=new Attribute(null);
		Attribute att2=new Attribute(null);
		
		att1.setAttributeName("aa");
		att2.setAttributeName("bb");
		Metadata meta;
		//Metadata meta2=new Metadata(att2, null);
		//d.setMetadata(meta,meta2);
		
			meta = new Metadata(att1,null);
		} catch (Exception e) {
			
			System.out.print(e.toString());
		}
		
		
		ResourceRegister pf=ResourceRegister.getinstance();
		
		
		*/
		


		
	
	}
}
