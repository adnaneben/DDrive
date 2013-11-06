package backend;

public interface DDrive {
	void move (String filePath, String destinationPath);
	void copy (String filePath, String destinationPath);
	byte[] download (String filePath);
	void upload (String filePath);
}
