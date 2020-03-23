package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {


    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;


    //Get all the comments made for the image
    public List<Comment> getAllComments(int image_id){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.id = :imageId ",Comment.class).setParameter("imageId",image_id);
        //TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c ",Comment.class);
        List<Comment> list = query.getResultList();
        return list;

    }

    public Comment createComment(Comment comment){
        EntityManager em  = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        }
        catch(Exception e){
            transaction.rollback();
        }
        return comment;

    }



}
