package com.hibernet.Controller;

import java.io.IOException;

import java.io.InputStream;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class DepartmentController {
	
		
	@RequestMapping("/file")
	public ModelAndView Dept(HttpServletRequest request,Model m) {
	
		
		return new ModelAndView("createdept");
	}
	
	@RequestMapping("/uploadfile")
	public ModelAndView createDept(@RequestParam("file") MultipartFile File,
			HttpServletRequest request) {
				
		
		
		
		return null;
	}




}
