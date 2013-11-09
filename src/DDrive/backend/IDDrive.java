package DDrive.backend;

/** This interface represents the template for all services.
 * 
 * It defines the basic functionality of moving, cloning, removing, downloading and
 * uploading files.
 * 
 * @author	Niklas Witzel
 */
public interface IDDrive {
	
	/** Moves the specified file to the specified destination.
	 * 
	 * @param sourceFile			Source directory
	 * @param destinationFile	Destination directory
	 */
	public void move (String sourceFile, String destinationFile);
	
	
	
	/** Clones the specified file to the specified destination.
	 * 
	 * @param sourceFile			Source path
	 * @param destinationFile	Destination path
	 */
	public void copy (String sourceFile, String destinationFile);
	
	
	
	/** Downloads the specified file.
	 * 
	 * @param sourceFile			Source path
	 * @param destinationFile	Destination path
	 */
	public void download (String sourceFile, String destinationFile);
	
	
	
	/** Uploads the specified file.
	 * 
	 * @param sourceFile			Source path
	 * @param destinationFile	Destination path
	 */
	void upload (String sourceFile, String destinationFile);
}