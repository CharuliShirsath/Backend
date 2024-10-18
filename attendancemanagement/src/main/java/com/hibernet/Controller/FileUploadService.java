package com.hibernet.Controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

public class FileUploadService {
	
	 private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>();
	    private static final Set<String> ALLOWED_MIME_TYPES = new HashSet<>();

	    static {
	        ALLOWED_EXTENSIONS.add("txt");
	        ALLOWED_EXTENSIONS.add("pdf");
	        ALLOWED_EXTENSIONS.add("xls");
	        ALLOWED_EXTENSIONS.add("xlsx");
	        ALLOWED_EXTENSIONS.add("jpg");
	        ALLOWED_EXTENSIONS.add("jpeg");
	        ALLOWED_EXTENSIONS.add("png");
	        ALLOWED_EXTENSIONS.add("docx");
	        ALLOWED_EXTENSIONS.add("doc");
	        ALLOWED_EXTENSIONS.add("gif");

	        // Add corresponding MIME types
	        ALLOWED_MIME_TYPES.add("text/plain");
	        ALLOWED_MIME_TYPES.add("application/pdf");
	        ALLOWED_MIME_TYPES.add("application/vnd.ms-excel");
	        ALLOWED_MIME_TYPES.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        ALLOWED_MIME_TYPES.add("image/jpeg");
	        ALLOWED_MIME_TYPES.add("image/png");
	        ALLOWED_MIME_TYPES.add("image/gif");
	        ALLOWED_MIME_TYPES.add("application/msword");
	        ALLOWED_MIME_TYPES.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	    }

	    public boolean isAllowedFile(String fileName, String mimeType) {
	        String extension = FilenameUtils.getExtension(fileName).toLowerCase();
	        return ALLOWED_EXTENSIONS.contains(extension) && ALLOWED_MIME_TYPES.contains(mimeType);
	    }

}
