package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repositories.CommentRepository;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Publication;
@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment addComment(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public Comment updateComment(Comment comment) {
		return commentRepository.save(comment);
	}

	
	@Override
	public List<Comment> retrieveAllComments() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public void deleteComment(Integer idComm) {
		 commentRepository.deleteById(idComm);

	}

	
	public Page<Comment> findCommentsWithPagination(int offset, int pageSize) {
		Page<Comment> comments = commentRepository.findAll(PageRequest.of(offset, pageSize));
	    return  comments;
	}

}


