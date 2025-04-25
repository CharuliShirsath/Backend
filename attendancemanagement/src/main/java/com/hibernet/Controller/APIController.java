package com.hibernet.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hibernet.detector.DocumentDetector;
import com.hibernet.sanitizer.DocumentSanitizer;


@RestController
public class APIController {
	
	//
	 private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>();
	    private static final Set<String> ALLOWED_MIME_TYPES = new HashSet<>();
	    private final Tika tika = new Tika();

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
	        ALLOWED_MIME_TYPES.add("application/vnd.ms-excel");
	        ALLOWED_MIME_TYPES.add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        ALLOWED_MIME_TYPES.add("image/jpeg");
	        ALLOWED_MIME_TYPES.add("image/png");
	        ALLOWED_MIME_TYPES.add("image/gif");
	        ALLOWED_MIME_TYPES.add("application/msword");
	        ALLOWED_MIME_TYPES.add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	        ALLOWED_MIME_TYPES.add("application/x-tika-msoffice");
	        ALLOWED_MIME_TYPES.add("application/x-tika-ooxml");
	        ALLOWED_MIME_TYPES.add("application/octet-stream");
	    }

	    private boolean hasDoubleExtension(String fileName) {
	        String[] parts = fileName.split("\\.");
	        return parts.length > 2; // More than one dot indicates a double extension
	    }

	    public boolean isAllowedFile(String fileName, String mimeType) {
	        String extension = getFileExtension(fileName).toLowerCase();
	        
	        System.out.println("mimeType===================>"+mimeType);
	        System.out.println("extension==================>"+extension);
	        
	        return ALLOWED_EXTENSIONS.contains(extension) && ALLOWED_MIME_TYPES.contains(mimeType);
	    }

	    private String getFileExtension(String fileName) {
	        int lastIndexOfDot = fileName.lastIndexOf(".");
	        if (lastIndexOfDot == -1 || lastIndexOfDot == fileName.length() - 1) {
	            return ""; // No extension
	        }
	        return fileName.substring(lastIndexOfDot + 1);
	    }

	
	//
	private static final String UPLOAD_DIR = "uploads/";
	
	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
	    	
	    	final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5 MB in bytes
	    	File tmpFile = null;
	    	
	        try {
	        	
	            // Create the upload directory if it doesn't exist
	            Path uploadPath = Paths.get(UPLOAD_DIR);
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }
	            
	            // Validate file size
	            if (file.getSize() > MAX_FILE_SIZE) {
	                return ResponseEntity.badRequest().body("File size exceeds the 5 MB limit.");
	            }
	            
	            // Check for double extension
	            if (hasDoubleExtension(file.getOriginalFilename())) {
	                return ResponseEntity.badRequest().body("Files with double extensions are not allowed.");
	            }
	            

	            // Detect MIME type using Apache Tika
	            String mimeType = tika.detect(file.getInputStream());

	            // Validate file extension and MIME type
	            if (!isAllowedFile(file.getOriginalFilename(), mimeType)) {
	                return ResponseEntity.badRequest().body("Invalid file extension or MIME type.");
	            }

//	            // Save the file to the upload directory
//	            Path filePath = uploadPath.resolve(file.getOriginalFilename());
//	            Files.copy(file.getInputStream(), filePath);
//	            
//	            //this is original code with using servelet done transform into spring boot


	            // Save the file to the upload directory
	            String fileName1 = file.getOriginalFilename();
	            Path filePath1 = uploadPath.resolve(fileName1);
	            Files.copy(file.getInputStream(), filePath1);
	            
	         // Write a temporary file with uploaded file
	            tmpFile = File.createTempFile("uploaded-", null);
	            
	            
	            /* Step 2: Initialize a detector/sanitizer for the target file type and perform validation */
	            boolean isSafe;

	            // Instantiate the dedicated detector/sanitizer implementation and apply detection/sanitizing
	            DocumentDetector documentDetector;
	            DocumentSanitizer documentSanitizer;
	            
	            String fileName = tmpFile.getName();
	         // Decode the file name
	            fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8.toString());

	            // Validate the file name
	            if (!isValidFileName(fileName)) {
	                throw new IllegalArgumentException("Invalid file name specified!");
	            }
	            
	            int lastIndexOfDot = fileName.lastIndexOf('.');
	            String extension = "";

	            if (lastIndexOfDot != -1 && lastIndexOfDot < fileName.length() - 1) {
	                extension = fileName.substring(lastIndexOfDot + 1);
	            }

	            System.out.println("File extension: " + extension);
	            
	            // Get the file extension
	            String fileExtension = getFileExtension(fileName);

	            return ResponseEntity.ok("File uploaded successfully: " + fileName +
	                    "\nMIME Type: " + mimeType + 
	                    "\nFile Extension: " + fileExtension);
	            
	            
	           // return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Failed to upload file: " + e.getMessage());
	        }
	    }

	    
	    
	    // added for sevelete
	    // Method to validate the file name
	    private boolean isValidFileName(String fileName) {
	        // Define a pattern for allowed file extensions
	        String regex = "^[\\w,\\s-]+\\.[a-zA-Z]{1,5}$"; // Basic regex for file names
	        Pattern pattern = Pattern.compile(regex);
	        
	        // Check for null bytes and double extensions
	        if (fileName.contains("\0") || fileName.contains("..")) {
	            return false;
	        }

	        // Validate the file name against the pattern
	        return pattern.matcher(fileName).matches();
	    }
	

}
