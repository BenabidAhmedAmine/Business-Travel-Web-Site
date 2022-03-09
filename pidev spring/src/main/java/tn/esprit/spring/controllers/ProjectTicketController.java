package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import tn.esprit.spring.entities.Document;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Joining;
import tn.esprit.spring.entities.Ticket;
import tn.esprit.spring.message.ResponseFile;
import tn.esprit.spring.message.ResponseMessage;
import tn.esprit.spring.services.FileStorageService;
import tn.esprit.spring.services.ProjectService;

@RestController

@RequestMapping("/project-ticket")
public class ProjectTicketController {
	@Autowired
	  private FileStorageService storageService;
	@Autowired
	private ProjectService ps;
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();
	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileDB fileDB = storageService.getFile(id);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  @PostMapping("/addticketandassigntoemployee/{idEmployee}")
	  @ResponseBody
		public void addticketandassigntoemployee(@RequestBody Ticket t,@PathVariable(value="idEmployee") Long idEmployee)
		{
			ps.addTicketAndAssingToEmployee(t, idEmployee);
		}
	  @PostMapping("/assignFileToTicket/{idFile}/{idTicket}")
	  @ResponseBody
		public void assignFileToTicket(@PathVariable(value="idFile") String idFile,@PathVariable(value="idTicket") Long idTicket)
		{
			ps.assignFileToTicket(idFile, idTicket);
		}
	  
}

