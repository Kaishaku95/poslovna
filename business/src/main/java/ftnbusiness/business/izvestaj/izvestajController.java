package ftnbusiness.business.izvestaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@RestController
@RequestMapping("/api/izvestaj")
public class izvestajController {
	
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriver;
	@Value("${spring.datasource.url}")
	private String dbUrl;
	private final String libPath = System.getProperty("user.dir") + System.getProperty("file.separator") + "lib" + System.getProperty("file.separator");
	
	@GetMapping(path="/FSS/{id}")
	public ResponseEntity<?> getFSS(@PathVariable Long id){
		
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("id", id);
		
		String jrxml = libPath + "FSS.jrxml";
		String jasper = libPath + "FSS.jasper";
		String filename = "FSS " + id + ".pdf";
		makeReport(jrxml, jasper, hm, filename);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path="/KIF/{beginDate}/{endDate}")
	public ResponseEntity<?> getKIF(@PathVariable Long beginDate, @PathVariable Long endDate){
		String jrxml = libPath + "KIF.jrxml";
		String jasper = libPath + "KIF.jasper";
		String filename = "KIF "+new Date().getTime()+".pdf";
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("beginDate", beginDate);
		hm.put("endDate", endDate);
		makeReport(jrxml, jasper, hm, filename);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private void makeReport(String reportFile, String jasper, Map<String, Object> hm, String filename) {
		String output = System.getProperty("user.dir") + System.getProperty("file.separator") + filename;
		try {
			JasperCompileManager.compileReportToFile(reportFile, jasper);
			Class.forName(dbDriver);
			Connection conn = DriverManager.getConnection(dbUrl, username, password);
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasper, hm, conn);
			JasperExportManager.exportReportToPdfFile(jprint, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
