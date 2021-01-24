import { Component, OnInit } from '@angular/core';
import { PostService } from '../../services/post.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../../model/post.model';

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html'
})
export class PostFormComponent implements OnInit {

  post: Post = {
    title: '',
    content: '',
    tags: '',
    published: false
  };
  message = '';

  constructor(
    private postService: PostService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
    this.message = '';
    const id = this.route.snapshot.params.id;
    if (id) {
      this.editPost(this.route.snapshot.params.id);
    }
  }

  editPost(id: string): void {
    this.postService.get(id)
      .subscribe(
        data => {
          this.post = data;
        },
        error => {
          console.error(error);
        });
  }

  savePost(): void {
    this.message = '';

    if (this.post.id) {
      this.saveEditedPost();
    } else {
      this.createNewPost();
    }
  }

  private createNewPost() {
    this.postService.create(this.post)
      .subscribe(
        response => {
          this.router.navigate([ '/posts' ]);
        },
        error => {
          console.error(error);
          this.message = 'An error occurred while saving post';
        });
  }

  private saveEditedPost() {
    this.postService.update(this.post.id, this.post)
      .subscribe(
        response => {
          this.router.navigate([ '/posts' ]);
        },
        error => {
          console.error(error);
          this.message = 'An error occurred while saving post';
        });
  }
}
