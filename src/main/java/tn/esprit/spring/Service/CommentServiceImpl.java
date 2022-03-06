package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.PublicationRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Entity.Comment;
import tn.esprit.spring.Entity.Publication;
@Service
public class CommentServiceImpl implements ICommentService{
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PublicationRepository publicationRepository;

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

	@Override
	public void ajouterEtaffecterListeComment(Comment comment, Integer pubId, Long Id) {
		// TODO Auto-generated method stub

		Publication publication = publicationRepository.findById(pubId).orElse(null);
	       User User = userRepository.findById(Id).orElse(null);
		comment.setPublication(publication);
		comment.setUser(User);
		commentRepository.save(comment);
		
	}

}


