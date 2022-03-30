package com.assignment.one.assignmentone.repo;

import com.assignment.one.assignmentone.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {

    private List<Post> posts = new ArrayList<>();

    PostRepoImpl(){
        posts.add(new Post(1,"Java Spring","About JPA","Sandesh Lohani"));
    }

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getByID(long id) {
        return posts.stream().filter(data->data.getId()==id).findFirst().get();
    }

    @Override
    public Post add(Post post) {
        int count = (int)posts.stream().filter(data->data.getId()==post.getId()).count();
        if(count==0) {
            if (posts.add(post)) {
                return post;
            }
        }

            return null;
    }

    @Override
    public Post update(Post post) {
        Post updatedPost = posts.stream().filter(data->data.getId()==post.getId()).findFirst().get();
        if(updatedPost!=null){
            updatedPost.setTitle(post.getTitle());
            updatedPost.setAuthor(post.getAuthor());
            updatedPost.setContent(post.getContent());
        }
        return updatedPost;
    }

    @Override
    public String delete(long id){
        String message = "";
        if(posts.size()>0) {
            int count = (int)posts.stream().filter(x -> x.getId() == id).count();
            if(count>0) {
                Post data = posts.stream().filter(x -> x.getId() == id).findFirst().get();
                message=posts.remove(data)?"Data Deleted Successfully":"Error in deletion of data";
            }
            else{
                message="No Associated data found";
            }
        }else{
            message="No Associated data found";
        }
        return message;
    }
}
