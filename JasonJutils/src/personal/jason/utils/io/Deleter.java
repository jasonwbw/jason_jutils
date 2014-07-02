package personal.jason.utils.io;

import java.io.File;
import java.io.FileNotFoundException;

public class Deleter {

	/**
	 * Delete file or or directory(include sub files) 
	 * @param file file path
	 * @throws FileNotFoundException 
	 */
	public static void deleteFile(File file) throws FileNotFoundException {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					deleteFile(files[i]);
				}
			}
			file.delete();
		} else {
			throw new FileNotFoundException();
		}
	}
}
