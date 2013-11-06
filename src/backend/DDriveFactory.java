package backend;

import backend.services.Dropbox;

public class DDriveFactory {
	
	public DDrive Create () {
		return new Dropbox ();
	}
}
