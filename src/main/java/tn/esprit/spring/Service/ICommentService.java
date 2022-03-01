package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.entities.Comment;


public interface ICommentService {
	
	public Comment addComment(Comment comment);
	public Comment updateComment(Comment comment);
	void deleteComment (Integer idComm);

	public List<Comment>retrieveAllComments();

}
