package DDrive.backend;

import DDrive.backend.IDDrive;
import DDrive.backend.services.Dropbox;
import DDrive.backend.services.GDrive;
import DDrive.backend.services.SkyDrive;
import DDrive.backend.services.UbuntuOne;

public class DDriveFactory {
	
	public IDDrive Create (ServiceEnum service) {
		switch (service) {
			case Dropbox:
				return new Dropbox ();
			
			case GDrive:
				return new GDrive ();
			
			case SkyDrive:
				return new SkyDrive ();
			
			case UbuntuOne:
				return new UbuntuOne ();
			
			default:
				return null;
		}
	}
}
