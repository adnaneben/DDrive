package DDrive;

import java.io.IOException;
import java.security.GeneralSecurityException;

import DDrive.backend.DDriveFactory;
import DDrive.backend.ServiceEnum;
import DDrive.backend.services.GDrive;

public class DDrive {
	public static void main (String[] args) {
		System.out.println ("DDrive started!");
		try {
			GDrive gd = (GDrive) DDriveFactory.Create (ServiceEnum.GDrive);
			gd.login ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace ();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace ();
		}
	}
}
