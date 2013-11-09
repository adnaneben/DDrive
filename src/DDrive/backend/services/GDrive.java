package DDrive.backend.services;

import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;

import DDrive.backend.IDDrive;

/* More information about the GDrive API:
 * https://developers.google.com/api-client-library/java/apis/drive/v2
 * 
 * Install the Google Plugin for Eclipse to Import the Drive API:
 * https://developers.google.com/eclipse/docs/download
 * 
 * Sample for the Drive API:
 * http://code.google.com/p/google-api-java-client/source/browse/drive-cmdline-sample/src/main/java/com/google/api/services/samples/drive/cmdline/DriveSample.java?repo=samples
 */
public class GDrive implements IDDrive {
    @SuppressWarnings("unused")
	private static final String APPLICATION_NAME = "DDrive-0.1";
    
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance ();
    
    private static HttpTransport httpTransport;
    
    private static FileDataStoreFactory dataStoreFactory;
    
    private static final java.io.File DATA_STORE_DIR = new java.io.File (System.getProperty ("user.home"), "DDrive");
    
    public GDrive() throws GeneralSecurityException, IOException {
	httpTransport = GoogleNetHttpTransport.newTrustedTransport ();
	dataStoreFactory = new FileDataStoreFactory (DATA_STORE_DIR);
    }
    
    public Credential login () throws IOException {
	// load client secrets
	InputStreamReader isr = new InputStreamReader (GDrive.class.getResourceAsStream ("client_secrets.json"));
	GoogleClientSecrets clientSecrets = GoogleClientSecrets.load (JSON_FACTORY, isr);
	
	// FIXME: the following if-block is just for debugging
	if (clientSecrets.getDetails ().getClientId ().startsWith ("Enter") || clientSecrets.getDetails ().getClientSecret ().startsWith ("Enter ")) {
	    System.out.println ("Enter Client ID and Secret from https://code.google.com/apis/console/?api=drive "
		    + "into drive-cmdline-sample/src/main/resources/client_secrets.json");
	    System.exit (1);
	}
	
	// set up authorization code flow
	GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder (httpTransport, JSON_FACTORY, clientSecrets, Collections.singleton (DriveScopes.DRIVE_FILE)).setDataStoreFactory (dataStoreFactory).build ();
	
	// authorize
	return new AuthorizationCodeInstalledApp (flow, new LocalServerReceiver ()).authorize ("user");
    }
    
    @Override
    public void move (String sourceFile, String destinationFile) {
	// TODO Auto-generated method stub
    }
    
    @Override
    public void copy (String sourceFile, String destinationFile) {
	// TODO Auto-generated method stub
    }
    
    @Override
    public void download (String sourceFile, String destinationFile) {
	// TODO Auto-generated method stub
    }
    
    @Override
    public void upload (String sourceFile, String destinationFile) {
	String sourceDir = sourceFile.substring (0, sourceFile.lastIndexOf (java.io.File.pathSeparatorChar));
	File fileMetadata = new File ();
	fileMetadata.setTitle (sourceDir);
	// TODO: finish this function
    }
}
