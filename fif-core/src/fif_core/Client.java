package fif_core;

import java.net.URI;

import fif_core.exceptions.DescriptorWithNoValidMetadataException;
import fif_core.exceptions.InterpretationNotEqualException;
import fif_core.exceptions.MetadataWithSameAttributeException;
import fif_core.interfaces.Aggregator;

public class Client {


	public static void main(String[] args) {
		
		
		try {
			
			//////////////////////////////risorsa
			
			Attribute attribute=new Attribute("genere");
			Attribute attribute2=new Attribute("editore");
			Attribute attribute3=new Attribute("autore");
			Attribute attribute4=new Attribute("anno");
			Attribute attribute5=new Attribute("versione");
			Attribute attribute6=new Attribute("a");
			
			
			FuzzySet fs_risorsa1=new FuzzySet();
			FuzzySet fs2_risorsa1=new FuzzySet();
			FuzzySet fs3_risorsa1=new FuzzySet();
			FuzzySet fs4_risorsa1=new FuzzySet();
			FuzzySet fs5_risorsa1=new FuzzySet();
			
			fs_risorsa1.setValue("horror", 0.7);
			fs_risorsa1.setValue("thriller", 0.5);
			fs_risorsa1.setValue("romanzo", 1.0);
			fs_risorsa1.setValue("dark romance", 0.2);
			
			fs2_risorsa1.setValue("TEA", 1.0);
			
			fs3_risorsa1.setValue("Anne Rice", 1.0);
			
			fs4_risorsa1.setValue("1980", 0.2);
			fs4_risorsa1.setValue("1981", 0.2);
			fs4_risorsa1.setValue("1982", 0.3);
			fs4_risorsa1.setValue("1983", 0.4);
			fs4_risorsa1.setValue("1984", 0.6);
			fs4_risorsa1.setValue("1985", 0.6);
			fs4_risorsa1.setValue("1986", 0.7);
			fs4_risorsa1.setValue("1987", 0.8);
			fs4_risorsa1.setValue("1988", 0.8);
			fs4_risorsa1.setValue("1989", 0.9);					
			fs4_risorsa1.setValue("1990", 1.0);			
			fs4_risorsa1.setValue("1991", 0.9);
			fs4_risorsa1.setValue("1992", 0.8);
			fs4_risorsa1.setValue("1993", 0.8);
			fs4_risorsa1.setValue("1994", 0.7);
			fs4_risorsa1.setValue("1995", 0.6);
			fs4_risorsa1.setValue("1996", 0.6);
			fs4_risorsa1.setValue("1997", 0.5);
			fs4_risorsa1.setValue("1998", 0.3);
			fs4_risorsa1.setValue("1999", 0.2);					
			fs4_risorsa1.setValue("2000", 0.2);
			

			fs5_risorsa1.setValue("brossura", 1.0);
			
			
			
			
			
			Metadata metadata_risorsa1=new Metadata(attribute,fs_risorsa1,OpenVeristicInterpretation.getinstance());
			Metadata metadata2_risorsa1=new Metadata(attribute2,fs2_risorsa1,OpenVeristicInterpretation.getinstance());
			Metadata metadata3_risorsa1=new Metadata(attribute3,fs3_risorsa1,OpenVeristicInterpretation.getinstance());
			Metadata metadata4_risorsa1=new Metadata(attribute4,fs4_risorsa1,OpenVeristicInterpretation.getinstance());
			Metadata metadata5_risorsa1=new Metadata(attribute5,fs5_risorsa1,OpenVeristicInterpretation.getinstance());
			
			Descriptor descrittoreRisorsa1=new Descriptor();
			
			descrittoreRisorsa1.setMetadata(metadata_risorsa1, metadata2_risorsa1,metadata3_risorsa1,metadata4_risorsa1,metadata5_risorsa1);
			
			URI id;
			id = new URI("L_ora_delle_streghe");
			
			Resource risorsa1= new Resource (id);
			
			ResourceRegister registro=ResourceRegister.getinstance();
			
			registro.associateDescriptor(risorsa1, descrittoreRisorsa1);
			

			
			//////////////////////////////////////////////////primo utente
			
			
			FuzzySet fs_utente1=new FuzzySet();
			FuzzySet fs2_utente1=new FuzzySet();
			FuzzySet fs3_utente1=new FuzzySet();
			FuzzySet fs4_utente1=new FuzzySet();
			FuzzySet fs5_utente1=new FuzzySet();
			
			fs_utente1.setValue("fantasy", 1.0);
			fs_utente1.setValue("romanzo gotico", 1.0);
			fs_utente1.setValue("horror", 0.7);
			fs_utente1.setValue("thriller", 0.5);
			fs_utente1.setValue("fantascienza", 0.3);
			fs_utente1.setValue("romanzo distopico", 0.4);
			fs_utente1.setValue("steampunk", 0.3);
			fs_utente1.setValue("storico", 0.3);
			
			fs2_utente1.setValue("salani", 1.0);
			fs2_utente1.setValue("mondadori", 0.9);
			fs2_utente1.setValue("urania", 0.5);
			fs2_utente1.setValue("TEA", 0.4);
			
			fs3_utente1.setValue("J.K Rowling", 1.0);
			fs3_utente1.setValue("David Eddings", 1.0);
			fs3_utente1.setValue("Terry Brooks", 1.0);
			fs3_utente1.setValue("Anne Rice", 0.8);
			
			fs4_utente1.setValue("1980", 0.2);
			fs4_utente1.setValue("1981", 0.4);
			fs4_utente1.setValue("1982", 0.7);
			fs4_utente1.setValue("1983", 0.3);
			fs4_utente1.setValue("1984", 0.3);
			fs4_utente1.setValue("1985", 0.2);
			fs4_utente1.setValue("1986", 0.3);
			fs4_utente1.setValue("1987", 0.4);
			fs4_utente1.setValue("1988", 0.4);
			fs4_utente1.setValue("1989", 0.9);					
			fs4_utente1.setValue("1990", 1.0);			
			fs4_utente1.setValue("1991", 1.0);
			fs4_utente1.setValue("1992", 0.8);
			fs4_utente1.setValue("1993", 0.6);
			fs4_utente1.setValue("1994", 0.5);
			fs4_utente1.setValue("1995", 0.5);
			fs4_utente1.setValue("1996", 0.3);
			fs4_utente1.setValue("1997", 0.4);
			fs4_utente1.setValue("1998", 0.5);
			fs4_utente1.setValue("1999", 0.7);					
			fs4_utente1.setValue("2000", 0.9);
			fs4_utente1.setValue("2001", 1.0);
			fs4_utente1.setValue("2002", 0.9);
			fs4_utente1.setValue("2003", 1.0);
			fs4_utente1.setValue("2004", 0.8);
			fs4_utente1.setValue("2005", 0.7);
			fs4_utente1.setValue("2006", 0.9);
			fs4_utente1.setValue("2007", 1.0);
			
			
			

			fs5_utente1.setValue("rilegata", 1.0);
			fs5_utente1.setValue("brossura", 0.7);
			fs5_utente1.setValue("tascabile", 0.6);
			fs5_utente1.setValue("digitale", 0.8);
			
			
			
			
			
			Metadata metadata_utente1=new Metadata(attribute,fs_utente1,OpenVeristicInterpretation.getinstance());
			Metadata metadata2_utente1=new Metadata(attribute2,fs2_utente1,OpenVeristicInterpretation.getinstance());
			Metadata metadata3_utente1=new Metadata(attribute3,fs3_utente1,OpenVeristicInterpretation.getinstance());
			Metadata metadata4_utente1=new Metadata(attribute4,fs4_utente1,OpenVeristicInterpretation.getinstance());
			Metadata metadata5_utente1=new Metadata(attribute5,fs5_utente1,OpenVeristicInterpretation.getinstance());
			
			DescriptionBasedFilter filtro_utente1=new DescriptionBasedFilter(metadata_utente1);
			DescriptionBasedFilter filtro2_utente1=new DescriptionBasedFilter(metadata2_utente1);
			DescriptionBasedFilter filtro3_utente1=new DescriptionBasedFilter(metadata3_utente1);
			DescriptionBasedFilter filtro4_utente1=new DescriptionBasedFilter(metadata4_utente1);
			DescriptionBasedFilter filtro5_utente1=new DescriptionBasedFilter(metadata5_utente1);
			
			Aggregator owa=new OWA(0.2,0.2,0.2,0.2,0.2);
			
			ParallelFilter filtro_parallelo_utente1=new ParallelFilter(owa, filtro_utente1,filtro2_utente1,filtro3_utente1,filtro4_utente1,filtro5_utente1);
			
			System.out.println(filtro_parallelo_utente1.doFilter(risorsa1));
			
			
			
			///////////////////////////////////////////////////////secondo utente
			
			
			FuzzySet fs_utente2=new FuzzySet();

			FuzzySet fs2_utente2=new FuzzySet();
			FuzzySet fs3_utente2=new FuzzySet();
			
			fs_utente2.setValue("fantasy", 1.0);
			fs_utente2.setValue("romanzo gotico", 0.9);
			fs_utente2.setValue("horror", 0.6);
			fs_utente2.setValue("thriller", 0.5);
			fs_utente2.setValue("fantascienza", 0.9);
			fs_utente2.setValue("romanzo distopico", 0.9);
			fs_utente2.setValue("steampunk", 1.0);
			fs_utente2.setValue("storico", 0.3);
			fs_utente2.setValue("romanzo", 0.6);
			

			fs2_utente2.setValue("1980", 0.6);
			fs2_utente2.setValue("1981", 0.4);
			fs2_utente2.setValue("1982", 0.7);
			fs2_utente2.setValue("1983", 0.3);
			fs2_utente2.setValue("1984", 0.3);
			fs2_utente2.setValue("1985", 0.2);
			fs2_utente2.setValue("1986", 0.3);
			fs2_utente2.setValue("1987", 0.4);
			fs2_utente2.setValue("1988", 0.4);
			fs2_utente2.setValue("1989", 1.0);					
			fs2_utente2.setValue("1990", 1.0);			
			fs2_utente2.setValue("1991", 1.0);
			fs2_utente2.setValue("1992", 0.8);
			fs2_utente2.setValue("1993", 0.6);
			fs2_utente2.setValue("1994", 0.5);
			fs2_utente2.setValue("1995", 0.5);
			fs2_utente2.setValue("1996", 0.5);
			fs2_utente2.setValue("1997", 0.6);
			fs2_utente2.setValue("1998", 0.6);
			fs2_utente2.setValue("1999", 0.9);					
			fs2_utente2.setValue("2000", 0.9);
			fs2_utente2.setValue("2001", 1.0);
			fs2_utente2.setValue("2002", 0.9);
			fs2_utente2.setValue("2003", 1.0);
			fs2_utente2.setValue("2004", 0.9);
			fs2_utente2.setValue("2005", 0.9);
			fs2_utente2.setValue("2006", 0.9);
			fs2_utente2.setValue("2007", 1.0);
			
			
			

			fs3_utente2.setValue("rilegata", 1.0);
			fs3_utente2.setValue("brossura", 0.8);
			fs3_utente2.setValue("tascabile", 0.8);
			fs3_utente2.setValue("digitale", 0.6);
			
			
			Aggregator owa2=new OWA((double)1/3,(double)1/3,(double)1/3);
			
			
			Metadata metadata_utente2=new Metadata(attribute,fs_utente2,OpenVeristicInterpretation.getinstance());
			Metadata metadata2_utente2=new Metadata(attribute4,fs2_utente2,OpenVeristicInterpretation.getinstance());
			Metadata metadata3_utente2=new Metadata(attribute5,fs3_utente2,OpenVeristicInterpretation.getinstance());
			
			DescriptionBasedFilter filtro_utente2=new DescriptionBasedFilter(metadata_utente2);
			DescriptionBasedFilter filtro2_utente2=new DescriptionBasedFilter(metadata2_utente2);
			DescriptionBasedFilter filtro3_utente2=new DescriptionBasedFilter(metadata3_utente2);
			
			
			
			ParallelFilter filtro_parallelo_utente2=new ParallelFilter(owa2, filtro_utente2,filtro2_utente2,filtro3_utente2);
			
			System.out.println(filtro_parallelo_utente2.doFilter(risorsa1));
			
			
			
	///////////////////////////////////////////////////////terzo utente
			
			
			FuzzySet fs_utente3=new FuzzySet();

			
			fs_utente3.setValue("fantasy", 0.7); 
			fs_utente3.setValue("romanzo gotico", 0.1); 
			fs_utente3.setValue("horror", 1.0); 
			fs_utente3.setValue("thriller", 1.0);
			fs_utente3.setValue("fantascienza", 0.9); 
			fs_utente3.setValue("romanzo distopico", 0.2);
			fs_utente3.setValue("steampunk", 0.05); 
			fs_utente3.setValue("storico", 0.25); 
			fs_utente3.setValue("romanzo", 0.5);
			

			
			
	
			
			Metadata metadata_utente3=new Metadata(attribute6,fs_utente3,OpenVeristicInterpretation.getinstance());
	
			
			DescriptionBasedFilter filtro_utente3=new DescriptionBasedFilter(metadata_utente3);

			
			
			
			
			
			System.out.println(filtro_utente3.doFilter(risorsa1));
			
			
		}
		catch (Exception e) {
			
			if(e instanceof InterpretationNotEqualException){	
				System.out.println("Stai eseguendo un matching tra una risorsa e un filtro utente che hanno 2 diverse interpretazioni.");
			}
			if(e instanceof MetadataWithSameAttributeException){
				System.out.println("Stai cercando di aggiungere ad un descrittore uno o pi� medatadati con lo stesso attributo.");
			}
			
			if(e instanceof DescriptorWithNoValidMetadataException){
				System.out.println("Nel descrittore della risorsa non � stato trovato alcun metadato con lo stesso attributo dei metadati del filro.");
			}
			
			
		}
		
		

	}

}
