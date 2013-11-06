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
	 * @param filePath			Source directory
	 * @param destinationPath	Destination directory
	 */
	void move (String filePath, String destinationPath);
	
	
	
	/** Clones the specified file to the specified destination.
	 * 
	 * @param filePath			Source path
	 * @param destinationPath	Destination path
	 */
	void copy (String filePath, String destinationPath);
	
	
	
	/** Downloads the specified file.
	 * 
	 * @param filePath			Source path
	 * @param destinationPath	Destination path
	 */
	void download (String filePath, String destinationPath);
	
	
	
	/** Uploads the specified file.
	 * 
	 * @param filePath			Source path
	 * @param destinationPath	Destination path
	 */
	void upload (String filePath, String destinationPath);
}
