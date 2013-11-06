package DDrive.backend;

import DDrive.backend.IDDrive;
import DDrive.backend.services.Dropbox;

public class DDriveFactory {
	
	public IDDrive Create (ServiceEnum service) {
		switch (service) {
			case Dropbox:
				return new Dropbox ();
			
			default:
				return null;
		}
	}
}
