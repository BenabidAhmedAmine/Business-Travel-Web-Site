package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import tn.esprit.spring.Entity.Comment;


public interface ICommentService {
	
	public Comment addComment(Comment comment);
	public Comment updateComment(Comment comment);
	void deleteComment (Integer idComm);

	public List<Comment>retrieveAllComments();
	public Page<Comment> findCommentsWithPagination(int offset,int pageSize);

}
