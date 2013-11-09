package DDrive.backend;

import java.io.IOException;
import java.security.GeneralSecurityException;

import DDrive.backend.IDDrive;
import DDrive.backend.services.Dropbox;
import DDrive.backend.services.GDrive;
import DDrive.backend.services.SkyDrive;
import DDrive.backend.services.UbuntuOne;

public class DDriveFactory {
	
	public static IDDrive Create (ServiceEnum service) throws GeneralSecurityException, IOException {
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
