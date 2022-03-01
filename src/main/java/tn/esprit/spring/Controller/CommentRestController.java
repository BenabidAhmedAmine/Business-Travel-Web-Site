package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.Service.CommentServiceImpl;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Publication;
import tn.spring.APIResponse;


@RestController
@Api(tags = "Comment management")
@RequestMapping("/comment")
public class CommentRestController {
	@Autowired
	CommentServiceImpl commentService;


	@ApiOperation(value = "Ajouter un comment")
	@PostMapping("/add-comment")
	@ResponseBody
	public Comment addComment(@RequestBody Comment comment)
	{
	Comment c = commentService.addComment(comment);
	return c;
	}
	
	@ApiOperation(value = "Mettre a jour un comment")
	@PutMapping("/modify-comment")
	@ResponseBody
	public Comment modifyComment(@RequestBody Comment comment) {
	return commentService.updateComment(comment);
}
	@DeleteMapping("/delete-comment/{idComm}")
	void deleteComment(@PathVariable(name="idComm") Integer idComm)
	{
		commentService.deleteComment(idComm);
	}
	
	@ApiOperation(value = "Récupérer la liste des comments")
	@GetMapping("/retrieve-all-comments")
	@ResponseBody
	public List<Comment> getComments() {
	List<Comment> listComments= commentService.retrieveAllComments();
	return listComments;
	}
	
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	   private APIResponse<Page<Comment>> getCommentsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	       Page<Comment> commentWithPagination = commentService.findCommentsWithPagination(offset, pageSize);
	       return new APIResponse<>(commentWithPagination.getSize(), commentWithPagination);
	   }
	
	}

