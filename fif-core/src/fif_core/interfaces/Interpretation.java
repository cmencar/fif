package fif_core.interfaces;

import fif_core.Metadata;

public interface Interpretation {
	
	public double match(Metadata filterMetadata, Metadata resourceMetadata);

}
